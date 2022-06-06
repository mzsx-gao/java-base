package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

import java.util.Map;

/**
 * @author  gaosd
 * @description ：(LeetCode-105) 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历inorder。请构造二叉树并返回其根节点。
 */
public class ConstructBTfromPreAndIn_105 {

    /*基于递归的实现*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
//        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
//
//        for(int i = 0; i < inorder.length; i++) {
//            inMap.put(inorder[i], i);
//        }
//        return buildTreeWithMap(0, 0, inorder.length - 1, preorder, inorder,inMap);
    }

    /**
     * @param preStart 前序数组的第一个元素，也就是根结点
     * @param inStart 中序数组的开始元素
     * @param inEnd 中序数组的结束元素
     * @return
     */
    public TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        /*构建二叉树的根结点*/
        TreeNode root = new TreeNode(preorder[preStart]);
        /*存放根结点在中序数组的位置*/
        int inIndex = 0;
        /*在中序数组中寻找根结点所在位置*/
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        /*递归的处理左右子树*/
        /*左子树的根结点就是前序数组中preStart的后一个元素，
        范围则是中序数组的inStart到inIndex - 1之间*/
        root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        /*右子树的根结点所在位置需要跳过整个左子树节点数目，也就是inIndex - inStart，
        所以根结点的位置就是preStart + inIndex - inStart再加1
        范围则是中序数组的inIndex + 1到n之间*/
        root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    /*使用Map加速查找过程*/
    public TreeNode buildTreeWithMap(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,
                                     Map<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        /*构建二叉树的根结点*/
        TreeNode root = new TreeNode(preorder[preStart]);
        /*存放根结点在中序数组的位置*/
        int inIndex = inMap.get(root.val);

        root.left = buildTreeWithMap(preStart + 1, inStart, inIndex - 1,
                preorder, inorder,inMap);
        root.right = buildTreeWithMap(preStart + inIndex - inStart + 1, inIndex + 1, inEnd,
                preorder, inorder,inMap);
        return root;
    }
}
