package gao.javabase.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode- 78) 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int begin, int[] nums, List<List<Integer>> res, ArrayList<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int j = begin; j < nums.length; j++) {
            cur.add(nums[j]);
            backtrack(j + 1, nums, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets_78().subsets(new int[] {1,2,3}));
    }
}
