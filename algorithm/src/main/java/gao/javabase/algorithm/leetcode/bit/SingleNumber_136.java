package gao.javabase.algorithm.leetcode.bit;

/**
 * @author  gaosd
 * @description ：(LeetCode-136) 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

}
