package gao.javabase.algorithm.leetcode.bit;

import java.util.Arrays;

/**
 * @author gaosd
 * @description ：(LeetCode-338) 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class CountingBits_338 {

    /*利用X &= (X - 1)清除最低位的1的功能来解决*/

    /**
     * Brian Kernighan算法的原理是：对于任意整数 x，令 x=x & (x−1)，该运算将 x 的二进制表示的
     * 最后一个 1 变成 0。因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x的 [1比特数]
     *
     *
     */
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    /*利用奇偶性解决*/
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        bits[0] = 0;
        for (int i = 1; i <= num; i++) {
            bits[i] = ((i & 1) == 1 ? bits[i - 1] + 1 : bits[i >> 1]);
        }
        return bits;
    }

    public static void main(String[] args) {
        int[] bits = new CountingBits_338().countBits(21);
        Arrays.stream(bits).forEach(n-> System.out.println(n));
    }
}
