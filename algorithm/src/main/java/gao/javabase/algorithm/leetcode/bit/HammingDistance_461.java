package gao.javabase.algorithm.leetcode.bit;

/**
 * @author  gaosd
 * @description ：(LeetCode-461) 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class HammingDistance_461 {

    public int hammingDistance(int x, int y) {
        int distance = 0;
        /*xor &= (xor - 1)用以清除最低位的1
        *比如，假设xor = 21，二进制表示为  0001 0101,
        * 则 21&20 = 0001 0101 & 0001 0100 = 0001 0100 = 20
        * 20&19 = 0001 0100 & 0001 0011 = 0001 0000= 16
        * 16&15 = 0001 0000 & 0000 1111 = 0*/
        for (int xor = x ^ y; xor != 0; xor &= (xor - 1)) {
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {
        new HammingDistance_461().hammingDistance(17,4);
    }
}
