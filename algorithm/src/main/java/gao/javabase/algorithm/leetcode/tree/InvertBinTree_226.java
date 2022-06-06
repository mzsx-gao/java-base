package gao.javabase.algorithm.leetcode.tree;

/**
 * @author  gaosd
 * @description ：(LeetCode-226) 翻转二叉树
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinTree_226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        //递归的翻转该节点的左子节点和右子节点
        invertTree(root.left);
        invertTree(root.right);

        //调换左右子节点的位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

    }
}