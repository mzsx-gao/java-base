package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 152) 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class MaxProductSubarray_152 {

    /*标准DP实现*/
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        /*最终的结果值变量，初始就取原始数组的第0个元素*/
        int answer = nums[0];
        /*定义DP并初始化；*/
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = nums[0]; minDP[0] = nums[0];
        /*使用状态转移公式，填充DP数组，并计算最大值*/
        for(int i = 1; i < nums.length; i++){
            maxDP[i] = Math.max(nums[i], Math.max(maxDP[i-1]*nums[i], minDP[i-1]*nums[i]));
            minDP[i] = Math.min(nums[i], Math.min(maxDP[i-1]*nums[i], minDP[i-1]*nums[i]));
            /*因为原始数组中存在着元素值为负数和0的情况，需要用answer记录当前已知的最大值*/
            answer = Math.max(answer, maxDP[i]);
        }
        return answer;
    }

    /*DP+滚动数组实现*/
    public int maxProduct2(int[] nums) {
        if(nums.length == 1) return nums[0];
        int answer = nums[0], max = nums[0], min = nums[0];
        for(int i=1; i<nums.length; i++){
            int currMax = max*nums[i],currMin = min*nums[i];
            max = Math.max(nums[i],Math.max(currMax,currMin));
            min = Math.min(nums[i],Math.min(currMax,currMin));
            answer = Math.max(answer, max);
        }
        return answer;
    }

    public static void main(String[] args) {
        new MaxProductSubarray_152().maxProduct2(new int[]{-4,-3,-2});
    }
}
