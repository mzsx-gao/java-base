package gao.javabase.algorithm.leetcode.array.phase3;

/**
 * @author  gaosd
 * @description ：(LeetCode-4) 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 */
public class Medianof2SortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        /*将数组元素个数总数为奇数和偶数情况统一处理
        * 奇数个数: left==right
        * 偶数个数: right==left+1
        * 比如 m=4,n=6,则left = 5,right = 6
        * m=4,n=5,则left = 5,right = 5 */
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getkth(nums1, 0, nums2, 0, left)
                + getkth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public double getkth(int[] nums1, int nums1Start, int[] nums2, int nums2Start, int k) {
        /*有任何一个数组空了，直接返回另外一个非空数组的中位数结果*/
        if (nums1Start > nums1.length - 1)
            return nums2[nums2Start + k - 1];
        if (nums2Start > nums2.length - 1)
            return nums1[nums1Start + k - 1];
        /*找第1小的数字，所以只需判断两个数组中第一个数字哪个小就可以了*/
        if (k == 1)
            return Math.min(nums1[nums1Start], nums2[nums2Start]);
        /*获得两个数组中第k/2个元素的值*/
        int num1Mid = Integer.MAX_VALUE, num2Mid = Integer.MAX_VALUE;
        if (nums1Start + k/2 - 1 < nums1.length)
            num1Mid = nums1[nums1Start + k/2 - 1];
        if (nums2Start + k/2 - 1 < nums2.length)
            num2Mid = nums2[nums2Start + k/2 - 1];

        /*比较两值的大小，然后以递归的形式继续更小数组的处理*/
        if (num1Mid < num2Mid)
            /*num1Mid更小，排除num1[]中小于等于num1Mid的部分*/
            return getkth(nums1, nums1Start + k/2,
                    nums2, nums2Start,k - k/2);
        else
            /*num2Mid更小，排除num2[]中小于等于num2Mid的部分*/
            return getkth(nums1, nums1Start, nums2,
                    nums2Start + k/2, k - k/2);
    }
}
