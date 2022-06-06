package gao.javabase.algorithm.leetcode.math;

import java.util.Random;

/**
 * @author gaosd
 * @description ：(LeetCode-470) 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，
 * 试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的 Math.random() 方法。
 */
public class ImplR10UseR7_470 {

    private Random r = new Random();

    public int rand7() {
        return r.nextInt(7);
    }

    public int rand10() {
        int temp = 40;
        while (temp >= 40) {
            temp = (rand7() - 1) * 7 + rand7() - 1;
        }
        return temp % 10 + 1;
    }

}
