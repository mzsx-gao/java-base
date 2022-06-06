package gao.javabase.algorithm.leetcode.tree.phase4;

import gao.javabase.algorithm.leetcode.tree.TreeNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-450) 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 */
public class DeleteNodeInBST_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        /*如果目标节点小于当前节点值，则去左子树中删除*/
        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }
        /*如果目标节点大于当前节点值，则去右子树中删除*/
        else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }
        /*找到了当前节点*/
        else{
            /*当前节点的左子树为空，返回当前节点的右子树后，
            上级节点指向当前节点的指针会被这个返回值所代替
            因为叶子节点的左右子树均为null，通过这种方式，
            叶子节点自然而然会被删除*/
            if(root.left==null){
                return root.right;
            }
            /*当前节点的右子树为空，返回当前节点的左子树后，
            上级节点指向当前节点的指针会被这个返回值所代替*/
            else if(root.right==null){
                return root.left;
            }
            else{/*当前节点的左右子树均不为空*/
                /*寻找当前右子树的最左节点*/
                TreeNode rightMin = root.right;
                while(rightMin.left!=null){
                    rightMin = rightMin.left;
                }
                /*当前节点左子树成为其右子树的最左节点的左子树*/
                rightMin.left = root.left;
                /*当前节点的的右子顶替其位置，节点被删除*/
                root = root.right;
            }
        }
        return root;
    }

}
