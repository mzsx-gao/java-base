package gao.javabase.algorithm.leetcode.dp.phase7;

import java.util.Arrays;

/**
 * @author  gaosd
 * @description ：(LeetCode- 64) 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinimumPathSum_64 {
    /*标准DP实现*/
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        /*DP数组初始化*/
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; ++i) {
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for(int j = 1; j < n; ++j) {
            dp[0][j] = grid[0][j]+dp[0][j-1];
        }
        /*使用状态转移公式，填充DP数组*/
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    /*标准DP+滚动数组实现*/
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        /*DP数组初始化*/
        dp[0] = grid[0][0];
        for(int j = 1;j < n ;j++){
            dp[j] = grid[0][j]+dp[j-1];
        }
        /*使用状态转移公式，填充DP数组*/
        for(int i = 1; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(j==0)
                    /*边界条件，需要单独处理*/
                    dp[j] = grid[i][j] + dp[j];
                else
                    dp[j] = grid[i][j]+Math.min(dp[j] , dp[j - 1]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum_64().minPathSum2(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));;
    }
}
