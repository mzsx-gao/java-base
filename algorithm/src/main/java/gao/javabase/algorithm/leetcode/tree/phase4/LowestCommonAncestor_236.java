package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-236) 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先
 * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*找到p或者q所在节点，终止递归；或者找到叶子节点也没找到p或者q*/
        if(root == null || root == p || root == q)  return root;
        /*返回时left和right的返回结果是p或者q或者为null，
        或者p和q的最近公共祖先node*/
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /*left和right不为空，说明p和q就在当前root节点下，
        root节点就是我们需要的最近公共祖先*/
        if(left != null && right != null)   return root;
        /*left和right有一个为空，返回不为空的那个
        * left和right的都为空，返回哪个都可以，这里统一返回right*/
        return left != null ? left : right;
    }
}
