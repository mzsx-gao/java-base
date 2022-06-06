package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author  gaosd
 * @description ：(LeetCode-199) 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class BTRightSideView_199 {

    /*递归实现*/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode root, List<Integer> result, int depth){
        if(root == null){
            return;
        }
        /*对于右子树来说，遇到一个右子树的节点，就加入结果集
        对左子树来说，只有结果集不存在右子树的节点，才会加入结果集*/
        if(depth == result.size()){
            result.add(root.val);
        }
        /*往下一层寻找，优先寻找右子树*/
        rightView(root.right, result, depth + 1);
        rightView(root.left, result, depth + 1);
    }

    /*利用层序遍历逆序和队列实现*/
    public List<Integer> rightSideViewWithQueue(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            /*获得每层的节点数*/
            int levelNodeNum = queue.size();
            /*处理本层的节点*/
            for (int i=0; i<levelNodeNum; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                /*和层序遍历不同，应该是右子树先入队*/
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return result;
    }
}
