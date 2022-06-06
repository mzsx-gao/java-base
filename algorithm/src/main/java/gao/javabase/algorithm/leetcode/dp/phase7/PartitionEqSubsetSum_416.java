package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 416) 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，
 * 使得两个子集的元素和相等。
 */
public class PartitionEqSubsetSum_416 {

    /*基于LeetCode的官方代码，做了简单调整*/
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        /*数组元素只有0个或者1个，直接返回false*/
        if (n < 2) {
            return false;
        }
        /*数组元素只有2个，直接判断*/
        if(n ==2){
            return nums[0] == nums[1]? true : false;
        }
        /*sum统计数组元素和，maxNum记录数组最大数值元素*/
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        /*sum为奇数，是不可能分为和相等的两个子集*/
        if (sum % 2 != 0)  return false;
        int target = sum / 2;
        /*数组最大数值大于数组元素和的一半，是不可能分为和相等的两个子集*/
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            /*数组存在元素大于数组元素和的一半，是不可能分为和相等的两个子集
             * 数组存在元素等于数组元素和的一半，一定可以分为相等的两个子集*/
            if(num >= target) return num > target ? false : true;
            for (int j = target; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    /*二维DP数组的实现*/
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        /*数组元素只有0个或者1个，直接返回false*/
        if (n < 2) {
            return false;
        }
        /*数组元素只有2个，直接判断*/
        if(n ==2){
            return nums[0] == nums[1]? true : false;
        }
        /*sum统计数组元素和，maxNum记录数组最大数值元素*/
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        /*sum为奇数，是不可能分为和相等的两个子集*/
        if (sum % 2 != 0)  return false;
        int target = sum / 2;
        /*数组最大数值大于数组元素和的一半，是不可能分为和相等的两个子集*/
        if (maxNum > target) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][target + 1];
        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                /*数组存在元素大于数组元素和的一半，是不可能分为和相等的两个子集
                * 数组存在元素等于数组元素和的一半，一定可以分为相等的两个子集*/
                if(nums[i] >= target) return nums[i] > target ? false : true;
                if(j >= nums[i - 1]) f[i][j] = f[i - 1][j - nums[i - 1]] || f[i - 1][j];
                else f[i][j] = f[i - 1][j];
            }
        }
        return f[n][target];
    }


    public static void main(String[] args) {
        new PartitionEqSubsetSum_416().canPartition2(new int[]{1,5,11,5});
    }
}
