package gao.javabase.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode- 46) 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] used = new int[nums.length];
        backtrack(result, nums, new ArrayList<Integer>(), used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> path, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            /*当前元素在祖先节点已经使用过，不再参与子孙节点的处理*/
            if (used[i] == 1) continue;

            path.add(nums[i]);
            /*标识当前元素已经使用*/
            used[i] = 1;
            backtrack(result, nums, path, used);
            /*准备回溯，处理其他分支，自然就要复原used和path*/
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
