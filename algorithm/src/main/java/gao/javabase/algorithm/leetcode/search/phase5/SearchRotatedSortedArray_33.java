package gao.javabase.algorithm.leetcode.search.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode- 33) 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class SearchRotatedSortedArray_33 {

    /*二分查找*/
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            int numMid = nums[mid];
            if(numMid == target) return  mid;
            /*numMid和target都大于nums[0]或者都小于nums[0]，说明nums[mid]和target在同一段
            *nums[mid]和target不在同一段，将numMid变为正无穷∞或者负无穷-∞*/
            if (!((numMid < nums[0]) == (target < nums[0]))) {
                numMid = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            /*mid所指示的数num比target小，移动start，否则移动end*/
            if (numMid < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    /*基于数组一半有序的原理*/
    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int num = nums[mid];
            if (target == num) {
                return mid;
            }
            /*左半段是有序的*/
            if (nums[start] <= num) {
                /*target 在这段里*/
                if (target >= nums[start] && target < num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            /*右半段是有序的*/
            } else {
                if (target > num && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
