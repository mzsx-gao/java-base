package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 718) 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class MaxRepeatedSubarray_718 {

    /*二维dp数组实现*/
    public int findLength(int[] nums1, int[] nums2) {

        int n1Length = nums1.length;
        int n2Length = nums2.length;

        int[][] dp = new int[n1Length + 1][n2Length + 1];
        int result = 0;
        for(int i = 1; i <=n1Length; i++ ){
            for(int j = 1; j <=n2Length; j++ ){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        return result;
    }

    /*一维dp数组实现*/
    public int findLength2(int[] nums1, int[] nums2) {

        int n1Length = nums1.length;
        int n2Length = nums2.length;

        int[] dp = new int[n2Length + 1];
        int result = 0;
        for(int i = 1; i <=n1Length; i++ ){
            for(int j = n2Length; j > 0; j-- ){
                if(nums1[i-1] == nums2[j-1]){
                    dp[j] = dp[j-1] + 1;
                }else{
                    dp[j] = 0;
                }
                result = Math.max(result,dp[j]);
            }
        }
        return result;
    }

}
