package gao.javabase.algorithm.leetcode.stackandqueue.phase4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author  gaosd
 * @description ：(LeetCode-84) 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangle_84 {

    /*基于单调栈的实现*/
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int result = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        /*遍历数组*/
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                /*当前需要计算面积的元素的下标*/
                int curIndex = stack.pollLast();
                /*获得当前元素的值，也就是矩形的高*/
                int curHeight = heights[curIndex];
                /*计算矩形的宽*/
                int curWidth;
                if (stack.isEmpty()) {
                    /*栈为空，表示目前遍历过所有元素都比当前的i要大，i是最小的一个，
                    宽度就可以直接取i的值*/
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }
                result = Math.max(result, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        /*处理目前还在栈中的元素*/
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            result = Math.max(result, curHeight * curWidth);
        }
        return result;
    }

    /*基于单调栈+哨兵的实现*/
    public int largestRectangleAreaWithSentinel(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int result = 0;

        int[] heightsWithSentinel = new int[len + 2];
        /*头哨兵，不会大于输入数组里任何一个元素，它肯定不会出栈，因此栈一定不会为空*/
        heightsWithSentinel[0] = 0;
        System.arraycopy(heights, 0, heightsWithSentinel, 1, len);
        /*尾哨兵，它不会大于输入数组里任何一个元素，
        它会让所有输入数组里的元素出栈（头边的哨兵元素除外）*/
        heightsWithSentinel[len + 1] = 0;
        len += 2;
        heights = heightsWithSentinel;

        Deque<Integer> stack = new LinkedList<Integer>();
        /*先放入头哨兵，在循环里就不用做非空判断*/
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                result = Math.max(result, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return result;
    }

    /*基于数组的实现*/
    public int largestRectangleAreaWithArray(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        /*存放元素右侧和左侧仅次于当前元素高度（或相同高度）的邻居元素下标的数组*/
        int[] leftLower = new int[heights.length];
        int[] rightLower = new int[heights.length];
        /*初始化*/
        rightLower[heights.length - 1] = heights.length;
        leftLower[0] = -1;

        /*正序遍历，对当前元素寻找左侧第一个小于当前元素高度（或相同高度）的邻居元素*/
        for (int i = 1; i < heights.length; i++) {
            /*从当前元素左侧第一个邻居元素开始，往左侧寻找*/
            int neighbourLeft  = i - 1;
            /*不断的往左寻找,一直到数组头或者左侧第一个小于等于当前元素的邻居元素为止*/
            while (neighbourLeft >= 0 && heights[neighbourLeft] >= heights[i]) {
                /*在我们的遍历过程中，当前元素的所有左侧元素我们已经处理过了，
                那就是说我们可以重用先前计算的结果快速跳转，比如数组
                {3,6,5,7,4,8,1,0}，
                假如当前元素是下标为4的元素4，很明显，前面的3,6,5,7都已经处理过,
                leftLower=
                [-1, 0, 0, 2, 0, 0, 0, 0],
                7会被5卡住，5和6都会被3卡住，4比7、5、6都小，
                可以快速到达5或6被卡住的地方判断4会不会也被卡住，
                neighbourLeft的变化将是 (4-1)3-->2=leftLower[3]-->0=leftLower[2]
                而heights[0]<heights[4]，退出循环，最终leftLower[4]=0*/
                neighbourLeft  = leftLower[neighbourLeft];
            }
            leftLower[i] = neighbourLeft ;
        }

        /*逆序遍历，对当前元素寻找右侧第一个小于当前元素高度（或相同高度）的邻居元素
        * 思想和上面的正序遍历一样，请自行分析*/
        for (int i = heights.length - 2; i >= 0; i--) {
            int neighbourRight = i + 1;
            while (neighbourRight < heights.length && heights[neighbourRight] >= heights[i]) {
                neighbourRight = rightLower[neighbourRight];
            }
            rightLower[i] = neighbourRight;
        }

        /*已经找到了所有元素对应的邻居元素，寻找最大的那个*/
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightLower[i] - leftLower[i] - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
         //int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {3,6,5,7,4,8,1,0};
        LargestRectangle_84 solution = new LargestRectangle_84();
        int res = solution.largestRectangleAreaWithArray(heights);
        System.out.println(res);
    }

}
