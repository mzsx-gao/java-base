package gao.javabase.algorithm.leetcode.dp;

/**
 * @author  gaosd
 * @description ：(LeetCode-121) 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i]
 * 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子
 * 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class BuyStock_121 {

    /*更快的实现*/
    public int maxProfitNoArray(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profitMax = 0 ;
        int min = prices[0] ;
        for (int i = 0 ; i < prices.length ; ++i) {
            if (prices[i] > min) {
                /*当前元素大于当前最小值，看看是否需要更新已知的最大差距*/
                profitMax = Math.max(profitMax, prices[i] - min) ;
            } else{
                /*当前元素小于等于当前最小值，更新当前最小值*/
                min = prices[i];
            }
            System.out.println("price["+i+"]="+prices[i]+", profitMax="+profitMax+" ,min="+min);
        }
        return  profitMax ;
    }

    /*动态规划的的实现*/
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            Tools.printTwoDimeArray(dp);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        int[] prices2 = new int[] {7,4,6,1,2};
        System.out.println(new BuyStock_121().maxProfit(prices));
    }
}
