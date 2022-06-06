package gao.javabase.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaosd
 * @description ：(LeetCode- 39) 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class CombinationSum_33 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        /*数组事先排序，方便后面剪枝*/
        Arrays.sort(candidates);
        backTrack(candidates, 0, candidates.length, target, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int[] candidates, int begin, int len, int target, List<Integer> path,
                           List<List<Integer>> res) {

        /*target被减为0，满足条件，加入总结果集小于0的部分会被剪枝*/
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        /*begin用来避免重复计算，比如减3分支不再计算减2*/
        for (int i = begin; i < len; i++) {
            /*数组已排序，进行剪枝*/
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backTrack(candidates, i, len, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] intArr = {2, 3, 6, 7};
        System.out.println(new CombinationSum_33().combinationSum(intArr, 7));
    }
}