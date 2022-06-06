package gao.javabase.algorithm.leetcode.dp.phase7;

import java.util.Arrays;

/**
 * @author  gaosd
 * @description ：(LeetCode- 300) 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素
 * 而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7]
 * 的子序列。
 */
public class LongestIncrSubseq_300 {

    /*标准DP实现*/
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*二分查找+DP实现*/
    public int lengthOfLIS3(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        /*因为dp数组中没有存放子序列的长度，需要我们单独统计
         * 用变量记录当前dp数组包含有效元素的实际长度*/
        int result = 1;
        dp[0] = nums[0];
        for(int i = 1 ;i < length;i++){
            if(nums[i] > dp[result-1]){
                dp[result] = nums[i];
                result++;
            }else{
                /*start和end指明了当前dp数组有效元素的起止位置*/
                int start = 0, end = result;
                /*以二分查找在dp数组中寻找第1个大于number的元素*/
                while(start < end) {
                    int m = (start + end) / 2;
                    if(dp[m] < nums[i])
                        start = m + 1;
                    else
                        end = m;
                }
                /*替换dp数组中的元素*/
                dp[start] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new LongestIncrSubseq_300().lengthOfLIS3(new int[]{10,9,2,5,3,7,101,18});
    }
}
