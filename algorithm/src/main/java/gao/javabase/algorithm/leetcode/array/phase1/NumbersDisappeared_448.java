package gao.javabase.algorithm.leetcode.array.phase1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode-448)找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class NumbersDisappeared_448 {

    /*利用数组nums来记录数字是否出现过，把数字变为负数*/
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int index = Math.abs(num) - 1 ;
            if( nums[index] >0 ) nums[index] = -nums[index];
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    /*利用数组nums来记录数字是否出现过，对数字+n*/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            /*对n取模来还原出原始元素值
            * 要记得原始元素值和数组下标有减1的关系，
            * 原始数组值在1~n之间，不减一的话会出现下标越界*/
            int x =  (num - 1) % n ;
            nums[x] += n;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                /*缺失的数记得在下标值之上加1*/
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(temp));
    }

}
