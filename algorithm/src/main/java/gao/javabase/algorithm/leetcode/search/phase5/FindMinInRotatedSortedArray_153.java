package gao.javabase.algorithm.leetcode.search.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode- 153) 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 *  * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，
 *  并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 */
public class FindMinInRotatedSortedArray_153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            /*如果start和end只相差一个元素，直接比较两者大小*/
            if (start + 1 == end) {
                return Math.min(nums[start], nums[end]);
            }
            int mid = (start + end) / 2;
            if(nums[start]<=nums[mid] && nums[mid]<=nums[end]){
                return nums[start];
                /*最小值在 left半区*/
            }else if(nums[start]>=nums[mid] && nums[mid]<nums[end]){
                end = mid ;
            }
            /*最小值在 right半区*/
            else{
                start = mid ;
            }
        }
        return -1;
    }
}
