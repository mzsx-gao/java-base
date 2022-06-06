package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author  gaosd
 * @description ：(LeetCode-98) 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBST_98 {

    /*基于二叉搜索树定义/性质实现*/
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        /*要么根节点本身为null，要么递归到了叶子节点，所以同时也是递归终止条件*/
        if (root == null) return true;
        /*节点不满足二叉搜索树定义，直接返回false*/
        if (root.val >= maxVal || root.val <= minVal) return false;
        /*对当前节点下的左右子树递归去判断，变化左子树的最大范围和右子树的最小范围*/
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    /*基于中序遍历的栈实现*/
    public boolean isValidBSTInOrderWithStack(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        /*用来存储前一个节点的值*/
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            /*如果当前节点的值不大于前一个节点的值，不符合二叉搜索树定义*/
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    TreeNode pre=null;
    /*基于中序遍历的递归实现*/
    public boolean isValidBSTInOrder(TreeNode root) {
        if(root==null) return true;
        if(!isValidBST(root.left))
            return false;
        /*这里用于判断是不是找到最左边的节点了，如果是就不用比较*/
        if(pre==null)
            pre=root;
        /*如果不是就比较这个节点和前一个节点的值*/
        else if(root.val<=pre.val)
            return false;
        pre=root;
        return isValidBST(root.right);
    }
}
