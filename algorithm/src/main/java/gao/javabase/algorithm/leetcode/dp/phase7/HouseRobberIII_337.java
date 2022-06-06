package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 337) 打家劫舍Ⅲ
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
。
 */
public class HouseRobberIII_337 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {
        int[] result = robNode(root);
        return Math.max(result[0],result[1]);
    }

    /*返回值表示当前节点root的结果，用长度为2的数组表示，
    下标[0]表示偷root时的最大值，下标[1]表示不偷root时的最大值*/
    private int[] robNode(TreeNode root){
        /*已经处理到了叶子节点的下层，递归终止*/
        if(root == null ) return new int[]{0,0};

        /*当前root节点的左子节点处理结果*/
        int[] left = robNode(root.left);
        /*当前root节点的右子节点处理结果*/
        int[] right = robNode(root.right);

        /*偷当前节点root时的值是
         root本身的值+不偷左子节点的最大值+不偷右子节点的最大值*/
        int stealCurr = root.val + left[1] + right[1];
        /*不偷当前节点root时的值是
         偷左子节点的值和不偷左子节点的值两者的最大值
         +偷右子节点的值和不偷右子节点的值两者的最大值*/
        int noStealCurr = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{stealCurr,noStealCurr};
    }
}
