package gao.javabase.algorithm.leetcode.dp;

/**
 * @author  gaosd
 * @description ：(LeetCode-53) 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 */
public class MaximumSubarray_53 {

    /*动态规划实现*/
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); // 状态转移公式
            if (dp[i] > result) result = dp[i]; // result 保存dp[i]的最⼤值
        }
        return result;
    }

    /*动态规划实现，但是不需要dp数组*/
    public int maxSubArrayNoDpArray(int[] nums) {
        int result = nums[0];
        int pre = result;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            if (pre > result) result = pre;
        }
        return result;
    }

    /*穷举实现*/
    public int maxSubArray2(int[] nums) {
        int ThisSum;
        int MaxSum = Integer.MIN_VALUE;
        int i, j;
        for (i = 0; i < nums.length; i++) {
            ThisSum = 0;
            for (j = i; j < nums.length; j++) {
                ThisSum += nums[j];
                if (ThisSum > MaxSum) {
                    MaxSum = ThisSum;
                }
            }
        }
        return MaxSum;
    }

    /*在线处理法实现*/
    public static int maxSubOnLine(int[] nums) {
        int i;
        int thisSum = 0;
        int maxSum = nums[0];
        for (i = 0; i < nums.length; i++) {
            if(thisSum>0){
                thisSum = thisSum + nums[i];
            }else{
                thisSum = nums[i];
            }
            maxSum = Math.max(maxSum, thisSum);
        }
        return maxSum;
    }
}
