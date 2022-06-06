package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-114) 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，
 * 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树先序遍历顺序相同。
 */
public class FlattenBTtoLinkedList_114 {

    /*递归实现，但是空间复杂度为O(n)*/
    public void flatten(TreeNode root) {
        if (root == null) return;
        /*将二叉树展开为链表之后会破坏二叉树的结构，需要事先存储左右子树*/
        TreeNode leftSave = root.left;
        TreeNode rightSave = root.right;
        /*将根结点的左子树置为null*/
        root.left = null;
        /*递归处理左右子树*/
        flatten(leftSave);
        flatten(rightSave);
        /*将左子树的节点加入链表，替换根结点的右子树*/
        root.right = leftSave;
        TreeNode cur = root;
        /*将右子树的节点加入链表*/
        while (cur.right != null) cur = cur.right;
        cur.right = rightSave;
    }

    /*循环实现，空间复杂度为O(1)*/
    public void flattenWithLoop(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                /*寻找左子树最右边的节点*/
                TreeNode rightmost = root.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                /*将原来的右子树挂到左子树的最右边节点的右指针上*/
                rightmost.right = root.right;
                /*将左子树挂到root节点的右指针上*/
                root.right = root.left;
                root.left = null;
                /*此时root节点的左子树已经为null,
                向下寻找，看看下面的节点上是否还存在着左子树，重复上述过程*/
                root = root.right;
            }
        }
    }

}
