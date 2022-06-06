package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 309) 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class BuyStockWithCooldown_309 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][4];
        dp[0][2] = -prices[0];
        for(int i = 1; i < length; i++){
            dp[i][0] = prices[i]+dp[i-1][2];
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] = Math.max(dp[i-1][1]-prices[i],Math.max(dp[i-1][2],dp[i-1][3]-prices[i]));
            dp[i][3] = dp[i-1][0];
        }
        return Math.max(dp[length-1][0],Math.max(dp[length-1][1],dp[length-1][3]));
    }

    public static void main(String[] args) {
        new BuyStockWithCooldown_309().maxProfit(new int[]{1,2,3,0,2});
    }
}
