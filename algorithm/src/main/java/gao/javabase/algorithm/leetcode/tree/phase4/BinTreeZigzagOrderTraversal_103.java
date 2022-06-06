package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode-103) 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class BinTreeZigzagOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode root, List<List<Integer>> result, int height){
        if(root == null) return;

        /*新的层需要增加新的子List*/
        if (height >= result.size()) {
            result.add(new LinkedList<Integer>());
        }

        List<Integer> subList  = result.get(height);
        /*因为要锯齿形层序遍历，所以对层高需要进行判断
        * 如果是从左到右，按普通的尾部追加节点即可
        * 如果是从右到左，使用头插法增加节点
        * */
        if(height % 2 == 0)
            subList.add(root.val);
        else
            subList.add(0, root.val);

        travel(root.left, result, height + 1);
        travel(root.right, result, height + 1);
    }
}
