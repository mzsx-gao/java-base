package gao.javabase.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode- 47) 全排列 II
 * 给定一个可包含重复数字的序列 nums ，
 * 按任意顺序 返回所有不重复的全排列。
 */
public class PermutationsII_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] used = new int[nums.length];
        /*数组事先排序，方便进行重复判定*/
        Arrays.sort(nums);
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

            /*判定当前元素是否重复处理了，
            *!(used[i-1]==1)用来保证这个判断是同层判定而不是子节点判定*/
            if ((i>0)&&nums[i]==nums[i-1]&&!(used[i-1]==1)) continue;

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
