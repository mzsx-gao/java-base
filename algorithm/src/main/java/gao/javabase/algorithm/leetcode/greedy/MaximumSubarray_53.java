package gao.javabase.algorithm.leetcode.greedy;

/**
 * @author  gaosd
 * @description ：(LeetCode-53) 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 */
public class MaximumSubarray_53 {

    /*贪心算法的实现*/
    public static int maxSubOnLine(int[] nums) {
        int i;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (i = 0; i < nums.length; i++) {
            if(currSum>0){
                currSum = currSum + nums[i];
            }else{
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
