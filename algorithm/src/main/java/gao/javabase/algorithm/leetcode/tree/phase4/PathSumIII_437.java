package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

import java.util.HashMap;

/**
 * @author  gaosd
 * @description ：(LeetCode-437) 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSumIII_437 {

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> prefixSum = new HashMap();
        /*Map的key就是前缀和，value记录是前缀和出现的次数
        初始化，任何节点本身也可以形成一个路径。
        如果某个节点的值就为target，
        那么它本身就是一个解。前缀和为0正好可以与它形成这个解。
        给所有节点一个可单独形成合法路径的机会。*/
        prefixSum.put(0,1);
        /*从根结点开始遍历*/
        return traversal(root, 0, sum, prefixSum);
    }

    public int traversal(TreeNode root, int currSum, int target,
                         HashMap<Integer, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }
        /*已有的前缀和加上当前节点的值形成的当前节点前缀和*/
        currSum = currSum+ root.val;
        /*差值 = 当前节点的前缀和-targetSum
        在前面保存的前缀和map中寻找有没有等于差值的记录
        result用来记录当前节点下满足条件的路径数*/
        int result = prefixSum.getOrDefault(currSum - target, 0);
        /*将当前节点的前缀和放入Map,有就说明现在多了一条满足题目要求的路径，+1，
        没有，这个前缀和初始的value为1*/
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        /*向下层节点递归遍历寻找满足条件的节点，左右子树的都要加上*/
        result = result + traversal(root.left, currSum, target, prefixSum)
                + traversal(root.right, currSum, target, prefixSum);
        /*一个节点的前缀和信息更新到map里时，它应当只对其子节点们有效,所以
        往上层返回的时候要减一*/
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return result;
    }
}
