package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 91) 解码方法
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1";... ; 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6) ; "KJF" ，将消息分组为 (11 10 6)
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 */
public class DecodeWays_91 {

    /*DP+滚动数组实现*/
    public int numDecodings(String s) {
        int n = s.length();
        /*取代DP数组的变量，类似于滚动数组
        * pre = 1 起到了类似DP数组初始化的作用*/
        int prePre = 0, pre = 1, curr = 0;
        /*DP数组中i是从1开始的，通过i定位原始字符串中的字符时，对应的下标就需要减1*/
        for (int i = 1; i <= n; ++i) {
            curr = 0;
            /*当前字符单独映射*/
            if (s.charAt(i - 1) != '0')   curr += pre;
            /*原始字符串当前元素i-1可以和前面的元素i-2组合满足映射关系*/
            if (i >= 2) {
                /*元素的组合转为数字*/
                int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (num >= 10 && num <= 26) curr += prePre;;
            }
            /*更新变量的值，为下个元素做准备*/
            prePre = pre;
            pre = curr;
        }
        return curr;
    }

    /*标准DP实现*/
    public int numDecodings2(String s) {
        int n = s.length();
        /*DP数组要比原始字符串长度大1*/
        int[] dp = new int[n + 1];
        /*DP数组初始化*/
        dp[0] = 1;
        /*DP数组中i是从1开始的，通过i定位原始字符串中的字符时，对应的下标就需要减1*/
        for (int i = 1; i <= n; i++) {
            /*单独解码原始字符串当前元素i-1*/
            if (s.charAt(i - 1) != '0') dp[i] = dp[i - 1];
            /*原始字符串当前元素i-1可以和前面的元素i-2组合满足映射关系*/
            if (i >= 2) {
                /*元素的组合转为数字*/
                int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (num >= 10 && num <= 26) dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
