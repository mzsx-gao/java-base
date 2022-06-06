package gao.javabase.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode-94) 二叉树的前序遍历
 */
public class BinTreePreOrderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root, res);
        return res;
    }

    public void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        accessTree(root.left, res);
        accessTree(root.right, res);
    }

    public List<Integer> preorderTraversalWithLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val); //前序遍历中对根结点的访问
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}