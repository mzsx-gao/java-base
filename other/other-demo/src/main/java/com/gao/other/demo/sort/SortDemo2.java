package com.gao.other.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

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
@Slf4j
public class SortDemo2 {

    /**
     * 插入排序
     * 时间复杂度:O(n^2),最好:O(n),最差(n^2)
     */
    @Test
    public void insertSort() {
        int a[] = {9, 8, 7, 0, 1, 3, 2};
        //这里面会有几层循环 2
        //时间复杂度：n^2
        for (int i = 1; i < a.length; i++) {//为什么i要从1开始？ 第一个不用排序，我们就把数组从i分开，0~I的认为已经排好序
            int data = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {//从尾到头 1+2+3+4+5+...+n=>
                if (a[j] > data) {
                    a[j + 1] = a[j];        // 数据往后移动
                } else {    //因为前面已经是排好序的 那么找到一个比他小的就不用找了，因为前面的肯定更小
                    break; //O(1)		如果这个break执行的越多 那么我是不是效率就越高?
                }
            }
            a[j + 1] = data;


            System.out.print("第" + i + "次的排序结果为：");
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 希尔排序
     * 基本思想:将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
     * 每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序
     * 时间复杂度:O(nlogn),最好:O(nlogn),最差(nlogn)
     */
    @Test
    public void hillSort() {
        int a[] = {9, 8, 7, 0, 1, 3, 2};
        int length = a.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < a.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }
                }
            }
        }

        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();
    }

    /**
     * 归并排序
     * 基本思想:归并排序算法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的，
     * 然后再把有序子序列合并为整体有序序列
     * 时间复杂度:nlogn
     */
    @Test
    public void test() {
        int data[] = {9, 5, 6, 8, 0, 3, 7, 1};
        megerSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public void megerSort(int data[], int left, int right) { // 数组的两端
        if (left < right) { // 相等了就表示只有一个数了 不用再拆了
            int mid = (left + right) / 2;
            megerSort(data, left, mid);
            megerSort(data, mid + 1, right);
            // 分完了 接下来就要进行合并，也就是我们递归里面归的过程
            merge(data, left, mid, right);
        }
    }

    public void merge(int data[], int left, int mid, int right) {
        int temp[] = new int[data.length]; //借助一个临时数组用来保存合并的数据

        int point1 = left;        //表示的是左边的第一个数的位置
        int point2 = mid + 1;     //表示的是右边的第一个数的位置

        int loc = left;           //表示的是我们当前已经到了哪个位置了
        while (point1 <= mid && point2 <= right) {
            if (data[point1] < data[point2]) {
                temp[loc] = data[point1];
                point1++;
                loc++;
            } else {
                temp[loc] = data[point2];
                point2++;
                loc++;
            }
        }
        //接下来要干嘛呢？合并排序完成了吗？
        while (point1 <= mid) {
            temp[loc++] = data[point1++];
        }
        while (point2 <= right) {
            temp[loc++] = data[point2++];
        }
        for (int i = left; i <= right; i++) {
            data[i] = temp[i];
        }
    }
}