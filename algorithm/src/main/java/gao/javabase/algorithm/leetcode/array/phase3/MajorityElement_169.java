package gao.javabase.algorithm.leetcode.array.phase3;

/**
 * @author  gaosd
 * @description ：(LeetCode-169) 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement_169 {

    /*Boyer-Moore 投票算法*/
    public int majorityElement(int[] nums) {
        /*对拼消耗的数字*/
        int currentNum = nums[0];
        /*对拼消耗的数字个数*/
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                /*对拼消耗的数字设置为当前元素*/
                currentNum = nums[i];
                count =  1;
            } else {
                if (nums[i] == currentNum) {
                    /*对拼消耗的数字个数增加*/
                    count++;
                } else {
                    /*数字不等，兑子，对拼消耗的数字个数减一*/
                    count--;
                }
            }
        }
        return currentNum;
    }
}
