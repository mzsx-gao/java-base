package gao.javabase.algorithm.leetcode.search.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode- 34) 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶： * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class FindFirstLastInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        /*如果第一个没找到，最后一个也不必找了*/
        if(result[0] == -1) return new int[]{-1,-1};
        /*找到第一个，寻找最后一个不需要从数组第0个元素开始寻找*/
        result[1] = findLast(result[0],nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            /*等于的情况下也不能停止寻找，一直要找到start > end为止，
            才是第一个target所在位置*/
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int first,int[] nums, int target){
        int idx = -1;
        int start = first;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
