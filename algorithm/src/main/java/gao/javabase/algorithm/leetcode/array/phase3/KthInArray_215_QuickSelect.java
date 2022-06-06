package gao.javabase.algorithm.leetcode.array.phase3;


import java.util.Arrays;

/**
 * @author  gaosd
 * @description ：(LeetCode-215) 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 */
public class KthInArray_215_QuickSelect {

    /*基于快速排序的分区实现*/
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的下标是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 快速排序分区方法
     */
    public int partition(int[] array, int start, int end) {
        /*只有一个元素时，无需再分区*/
        if(start == end) return start;
        /*随机选取一个基准数*/
        int pivot = (int) (start + Math.random() * (end - start + 1));
        /*zoneIndex是分区指示器，初始值为分区头元素下标减一*/
        int zoneIndex = start - 1;
        /*将基准数和分区尾元素交换位置*/
        swap(array, pivot, end);
        for (int i = start; i <= end; i++){
            /*当前元素小于等于基准数*/
            if (array[i] <= array[end]) {
                /*首先分区指示器累加*/
                zoneIndex++;
                /*当前元素在分区指示器的右边时，交换当前元素和分区指示器元素*/
                if (i > zoneIndex)
                    swap(array, i, zoneIndex);
            }
        }
        return zoneIndex;
    }

    /**
     * 交换数组内两个元素
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
