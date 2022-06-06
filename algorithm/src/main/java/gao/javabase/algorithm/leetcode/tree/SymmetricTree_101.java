package gao.javabase.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gaosd
 * @description ：(LeetCode-101) 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    /  \
 *   2    2
 *  / \  / \
 * 3  4  4  3
 */
public class SymmetricTree_101 {

    //解法一:递归实现
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return deepCheck(root.left, root.right);
    }

    boolean deepCheck(TreeNode left, TreeNode right) {
        /**
         * 递归的终止条件:
         * 1.两个节点都为空
         * 2.两个节点中有一个为空
         * 3.两个节点的值不相等
         */
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        /**
         * 再递归的比较
         * 1.左节点的左孩子 和 右节点的右孩子
         * 2.左节点的右孩子 和 右节点的左孩子
         */
        return deepCheck(left.left, right.right) && deepCheck(left.right, right.left);
    }

    // 解法二:队列实现
    public boolean isSymmetricWithQueue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode u = root.left;
        TreeNode v = root.right;
        if (root == null || (u == null && v == null)) {
            return true;
        }
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;

    }
}