package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-538) 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
public class ConvertBSTtoGT_538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        accessTree(root);
        return root;
    }

    public void accessTree(TreeNode root) {
        if (root == null) return;
        accessTree(root.right);
        root.val += sum;
        sum = root.val;
        accessTree(root.left);
    }
}
