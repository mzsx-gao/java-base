package gao.javabase.algorithm.leetcode.array.phase3;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  gaosd
 * @description ：(LeetCode-215) 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 */
public class KthInArray_215_HeapSort {

    /*直接利用JDK中的优先队列来实现堆排序，进而实现题目的要求
    * JDK中的优先队列默认是最小堆，最大堆需要自行实现Comparator*/
    public int findKthLargestWithPQ(int[] nums, int k) {
        /*使用一个含有 k 个元素的最小堆*/
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            /*获取但并不弹出栈顶元素*/
            /*当前遍历的元素比堆顶元素大，当前元素替换栈顶元素*/
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    /*利用最大堆实现本题要求*/
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        /*1.构建一个最大堆*/
        buildMaxHeap(nums,len);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --len;
            adjustHeap(nums, 0,len);
        }
        return nums[0];
    }

    /* 建立最大堆*/
    public void buildMaxHeap(int[] array, int heapSize) {
        /*从最后一个非叶子节点开始向上构造最大堆*/
        for (int i = (heapSize/2-1); i >= 0; i--) {
            adjustHeap(array, i,heapSize);
        }
    }

    /* 调整使之成为最大堆*/
    public void adjustHeap(int[] array, int i, int heapSize) {
        int maxIndex = i;
        int left = 2*i+1;
        int right = 2*(i+1);
        /*如果有左子树，且左子树大于父节点，则将最大指针指向左子树*/
        if (left < heapSize && array[left] > array[maxIndex])
            maxIndex = left;
        /*如果有右子树，且右子树大于父节点且大于左子树，则将最大指针指向右子树*/
        if (right < heapSize && array[right] > array[maxIndex]&&array[right]>array[left])
            maxIndex = right;
        /*如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。*/
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex,heapSize);
        }
    }

    /* 交换数组内两个元素*/
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
