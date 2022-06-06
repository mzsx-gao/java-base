package gao.javabase.algorithm.leetcode.stackandqueue.phase4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author  gaosd
 * @description ：(LeetCode-739) 每日温度
 * 请根据每日气温列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures_739 {

    /*标准栈的解法*/
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();;
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    /*用倒序遍历数组来求解*/
    public int[] dailyTemperaturesUseArray(int[] temperatures) {
        int length = temperatures.length;
        int[] ret = new int[length];

        /*从右向左遍历，数组最后一个元素无需处理*/
        for (int i = length - 2; i >= 0; i--) {
            /*backIdx表示从当前元素开始往后寻找获得需要的结果，
            backIdx=backIdx+ret[backIdx]是为了利用已经有的结果进行跳跃*/
            for (int backIdx = i + 1; backIdx < length; backIdx=backIdx+ret[backIdx]) {
                if (temperatures[backIdx] > temperatures[i]) {
                    ret[i] = backIdx - i;
                    break;
                } else if (ret[backIdx] == 0) {/*遇到0表示后面不会有更大的值，那当然当前值就应该也为0*/
                    ret[i] = 0;
                    break;
                }
            }
        }
        return ret;
    }
}
