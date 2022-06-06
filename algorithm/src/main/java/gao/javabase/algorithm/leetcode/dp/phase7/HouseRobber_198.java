package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 198) 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class HouseRobber_198 {

    /*标准DP解法*/
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] dp = new int[length];
        dp[0] = nums[0];
        /*要注意这里dp[1]不能直接等于nums[1]，要记住dp数组元素的定义：
        * DP数组当前元素时满足条件下的能偷窃到的最高金额*/
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i = 2 ;i<length; i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        return dp[length-1];
    }

    /*标准DP解法，减少对DP数组的初始化*/
    public int rob3(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] dp = new int[length];
        dp[0] = nums[0];
        for(int i = 1 ;i<length; i++){
            /*防止下标越界，单独处理i=1的情况*/
            if(i == 1) {
                dp[i] = Math.max(dp[i-1],nums[i]);
                continue;
            }
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        return dp[length-1];
    }

    /*DP解法+滚动数组*/
    public int rob2(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int prePre = nums[0];
        int pre = nums[0] > nums[1] ? nums[0] : nums[1];
        int current  = 0;
        for(int i = 2 ;i<length; i++){
            current = Math.max(pre,nums[i] + prePre);
            prePre = pre;
            pre = current;
        }
        return current;
    }
}
