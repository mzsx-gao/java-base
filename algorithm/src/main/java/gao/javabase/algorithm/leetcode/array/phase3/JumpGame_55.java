package gao.javabase.algorithm.leetcode.array.phase3;

/**
 * @author  gaosd
 * @description ：(LeetCode-55) 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        /*从倒数第二个元素开始倒序往前找*/
        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                /*如果存在当前元素=0的情况，需要找到可以跳过这个0的数组元素值*/
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    /*要记得，每倒序往前走一个元素，需要跳过的数值也要加1*/
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }

    /*基于动态规划的实现*/
    public boolean canJumpWithDP(int[] nums) {
        int n=nums.length;
        int maxStep=nums[0];
        for(int i=1;i<n;i++){
            if(maxStep==0)  return false;
            maxStep=Math.max(maxStep-1,nums[i]);
        }
        return true;
    }
}
