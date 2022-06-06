package gao.javabase.algorithm.leetcode.dp.phase7;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author  gaosd
 * @description ：(LeetCode- 42) 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrappingRainWater_42 {

    /*双指针实现*/
    public int trap3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    /*动态规划实现*/
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        /* 正向遍历数组填充DP数组leftDp*/
        int[] leftDp = new int[n];
        leftDp[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i]);
        }
        /* 反向遍历数组填充DP数组rightDp*/
        int[] rightDp = new int[n];
        rightDp[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i]);
        }
        /* 遍历每个下标位置即可得到能接的雨水总量*/
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result += Math.min(leftDp[i], rightDp[i]) - height[i];
        }
        return result;
    }

    /*使用单调栈实现，LeetCode官方代码*/
    public int trapWithStack(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            System.out.println("curr = "+i);
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                System.out.println("curr = "+i+" top = "+top);
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                System.out.println("currWidth = " + currWidth);
                int currHeight = Math.min(height[left], height[i]) - height[top];
                System.out.println("currHeight = " + currHeight);
                ans += currWidth * currHeight;
                System.out.println("ans = " + ans);
            }
            stack.push(i);
            System.out.println("+++++++++++++++++");
        }
        return ans;
    }

    public static void main(String[] args) {
        new TrappingRainWater_42().trapWithStack(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});

    }

    /*双指针实现*/
    public int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
