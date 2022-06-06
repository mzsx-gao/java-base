package gao.javabase.algorithm.leetcode.sort;

/**
 * @author gaosd
 * 类说明：冒泡算法（升序）
 */
public class Test {
    public int[] sortArray(int[] nums) {

        //冒泡排序
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - 1 - i; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    int temp = nums[j + 1];
//                    nums[j + 1] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }

        //选择排序
//        for (int i = 0; i < nums.length; i++) {
//            int minIndex = i;
//            for (int j = i; j < nums.length; j++) {
//                if(nums[j] < nums[minIndex]){
//                    minIndex = j;
//                }
//            }
//            int temp = nums[minIndex];
//            nums[minIndex] = nums[i];
//            nums[i] = temp;
//        }

        //插入排序
        for (int i = 1; i < nums.length; i++) {
            int index = i;
            int data = nums[i];
            //找到当前数字应该插入的位置
            for (int j = i; j > 0; j--) {
                if (data < nums[j - 1]) {
                    index = j - 1;
                }
            }
            //其它数字统一向后移动
            for (int m = i; m > index; m--) {
                nums[m] = nums[m - 1];
            }
            //把当前数字插入该位置
            nums[index] = data;
        }

        return nums;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = new Test().sortArray(PrintArray.SRC);
        PrintArray.print(dest);
    }
}