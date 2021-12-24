package com.gao.other.demo.sort;

import org.junit.Test;

/**
 * 描述: 排序算法
 * O(1)>O(logn)>O(n)>O(nlogn)>O(n^2)
 * 八大排序算法：
 * 插入排序、希尔排序、归并排序
 * 选择排序、冒泡排序、快速排序
 * 堆排序、基数排序
 *
 * @author gaoshudian
 * @date 12/09/21 3:41 PM
 */
public class SortDemo {

    /**
     * 简单选择排序
     * 时间复杂度:平均:O(n²),最好:O(n²),最差(n²)
     */
    @Test
    public void sort1() {
        int[] a = {6, 3, 9, 4, 5, 7, 8};
        for (int i = 0; i < a.length; i++) {
            int min = i;
            //选出之后待排序中值最小的位置
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //最小值不等于当前值时进行交换
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度: 平均:O(n²),最好:O(n),最差(n²)
     */
    public static void sort2() {

        int[] a = {6, 3, 9, 4, 5, 7, 8};
        //外层循环控制比较的次数
        for (int i = 0; i < a.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < a.length - i - 1; j++) {
                //前面的元素比后面大就交换
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度: 平均:O(nlog₂n),最好:O(nlog₂n),最差O(n²)
     * 伪代码描述：
     * i = L; j = R; 将基准数挖出形成第一个坑a[i]。
     * j--，由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * i++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 再重复执行2，3二步，直到i==j，将基准数填入a[i]中
     */
    @Test
    public void sort3(String[] args) {
        System.out.println("快速排序");
        int[] arr = {6, 3, 9, 4, 5, 7, 8};
        quickSort(arr, 0, 6);
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void quickSort(int[] a, int low, int high) {

        //已经排完
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;

        //保存基准值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素
            while (left < right && a[right] >= pivot)
                right--;
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot)
                left++;
            a[right] = a[left];
        }
        // 放置基准值，准备分治递归快排
        a[left] = pivot;
        quickSort(a, low, left - 1);
        quickSort(a, left + 1, high);
    }

}