package gao.javabase.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode-94) 二叉树的中序遍历
 */
public class BinTreeInOrderTraversal_94 {

    //解法一:递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root, res);
        return res;
    }

    public void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        accessTree(root.left, res);
        res.add(root.val);
        accessTree(root.right, res);
    }

    //解法二:循环迭代
    public List<Integer> inorderTraversalWithLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}