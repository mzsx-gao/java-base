package gao.javabase.algorithm.leetcode.dp;

/**
 * @author  gaosd
 * @description ：斐波那契数，也是剑指Offer 10
 */
public class FibonacciNumber_509 {

    /*动态规划的实现*/
    public int fib(int n) {
        if (n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*递归的解法*/
    public int fibRecursive(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibRecursive(n-1)+fibRecursive(n-2);
    }


    /*循环的解法，自底向上累加，和动态规划的实现有着异曲同工之妙
    * 只是这里占用的空间更少*/
    public int fibLoop(int n) {
        if (n<=1) return n;
        int result = 0;
        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; ++i) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}