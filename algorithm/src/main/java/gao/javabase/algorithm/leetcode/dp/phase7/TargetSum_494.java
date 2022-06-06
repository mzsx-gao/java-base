package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 494) 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class TargetSum_494 {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        if(n == 1) return nums[0] == target || nums[0] == -target ? 1 : 0;

        /*sum统计数组元素和*/
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        /* 加数集合和 = (target  + 数组nums所有元素之和sum)/2
         * 减数集合和 = (数组nums所有元素之和sum - target )/2*/
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int need = diff / 2;
        int[] dp = new int[need + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = need; j >= num; j--){
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[need];
    }

}
