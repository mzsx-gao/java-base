package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author  gaosd
 * @description ：(LeetCode-102) 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * （即逐层地，从左到右访问所有节点）。
 */
public class BinTreeLevelOrderTraversal_102 {

    /*基于队列的实现*/
    public List<List<Integer>> levelOrderWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(root == null) return result;

        /*放入根结点*/
        queue.offer(root);
        while(!queue.isEmpty()){
            /*获得每层的节点数*/
            int levelNodeNum = queue.size();
            /*每层的结果集*/
            List<Integer> subList = new LinkedList<Integer>();
            /*处理本层的节点，包括输出节点值和将节点的左右子树入队*/
            for(int i=0; i<levelNodeNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }

    /*基于递归的实现*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelPreVisit(result, root, 0);
        return result;
    }

    public void levelPreVisit(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) return;
        /*新的层需要增加新的子List*/
        if (height >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        /*对当前结点的处理需要注意所在的层*/
        result.get(height).add(root.val);
        levelPreVisit(result, root.left, height+1);
        levelPreVisit(result, root.right, height+1);
    }
}
