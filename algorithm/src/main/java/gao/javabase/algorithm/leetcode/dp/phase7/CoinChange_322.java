package gao.javabase.algorithm.leetcode.dp.phase7;

import java.util.Arrays;

/**
 * @author  gaosd
 * @description ：(LeetCode- 322) 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；
 * 以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1
 */
public class CoinChange_322 {

    /*第一版实现*/
    public int coinChangeAll(int[] coins, int amount) {
        int n = coins.length;
        int impossible = amount + 1;
        /*dp数组，其中的元素dp[i][j] 表示从前i种硬币中选，
        且总金额恰好为j的所需要的最少硬币个数*/
        int[][] dp = new int[n + 1][impossible];
        /*初始化dp数组，每个元素最多的硬币个数一定是i值本身，
        通过判断DP数组最后一个值是否为amount+1返回最终结果*/
        for (int i = 0; i <= n; i++)
            for(int j = 0; j <= amount; j++)
                dp[i][j] = impossible;
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int m = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                /*不管第i个硬币取几个，金额不能超过j*/
                for (int k = 0; k * m <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*m] + k);
                }
            }
        }
        return dp[n][amount] == impossible ? -1 : dp[n][amount];
    }

    /*第二版实现*/
    public int coinChange(int[] coins, int amount) {
        int impossible  = amount+1;
        int[] dp = new int[impossible];
        /*初始化dp数组，每个元素最多的硬币个数一定是i值本身，
        通过判断DP数组最后一个值是否为amount+1返回最终结果*/
        Arrays.fill(dp,impossible);
        dp[0] = 0;
        /*对于dp数组中的每个元素，判断当前元素（金额）如何由coins组成可以个数最少
        * 对于每个金额i都会遍历coins数组一次计算个数，并填充dp数组*/
        int n = coins.length;
        for(int i = 0; i < n;i++){
            for(int j = 1;j<= amount; j++){
                /*总金额i大于等于coins数组中当前元素j的值，才有计算的意义*/
                if(j >= coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount] == impossible ? -1:dp[amount];
    }

    public static void main(String[] args) {
        new CoinChange_322().coinChange(new int[]{1, 2, 5},11);
    }

}
