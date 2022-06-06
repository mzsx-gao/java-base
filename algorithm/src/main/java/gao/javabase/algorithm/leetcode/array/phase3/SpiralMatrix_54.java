package gao.javabase.algorithm.leetcode.array.phase3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode-54) 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，
 * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return list;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int plies = 0;/*层数指示器*/

        /*获得矩阵的层数*/
        int count = (Math.min(rowLength, colLength)+1)/2;
        /*从外部向内部遍历，逐层打印数据*/
        while(plies < count) {
            /*每层矩阵的起始元素都是matrix[plies][plies]*/
            /*从左至右，到matrix[plies][colLength-1-plies]时停止，准备转向*/
            for (int j = plies; j < colLength-plies; j++) {
                list.add(matrix[plies][j]);
            }
            /*从上往下，本列的第一个元素已经在上面的“从左至右”中处理了，
            * 所以行从应该从plies+1开始，列(colLength-1-plies)维持不变，
            * 起始元素就是matrix[plies+1][colLength-1-plies]，
            * 到matrix[rowLength-1-plies][colLength-1-plies]时停止，准备转向*/
            for (int j = plies+1; j < rowLength-plies; j++) {
                list.add(matrix[j][(colLength-1)-plies]);
            }
            /*从右往左，本行的第一个元素已经在上面的“从上往下”中处理了，
            * 所以列应该从(colLength-1-plies)-1开始，行维持不变，
            * 起始元素就是matrix[rowLength-1-plies][(colLength-1-plies)-1]，
            * 到matrix[rowLength-1-plies][plies]时停止，准备转向*/
            /*rowLength-1-plies == plies，表示本层只有单行，不必再处理*/
            for (int j = (colLength-1)-(plies+1); j >= plies && (rowLength-1-plies != plies); j--) {
                list.add(matrix[(rowLength-1)-plies][j]);
            }
            /*从下往上，本列的第一个元素已经在上面的“从右往左”中处理了，
             * 所以行从应该从(rowLength-1-plies)-1开始，列(plies)维持不变，
             * 起始元素就是matrix[(rowLength-1-plies)-1][plies]，
             * 到matrix[plies+1][plies]时停止*/
            /*colLength-1-plies != plies，表示本层只有单列，不必再处理*/
            for (int j = (rowLength-1)-(plies+1); j >= plies+1 && (colLength-1-plies != plies); j--) {
                list.add(matrix[j][plies]);
            }
            plies++; /*层数累加*/
        }
        return list;
    }
}
