package gao.javabase.algorithm.leetcode.search.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode- 240) 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m * n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Search2DMatrixII_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) {
            return false;
        }
        /*矩阵行和列下标的最大值*/
        int cols = matrix[0].length-1;
        int rows = matrix.length-1;
        /*目标值大于矩阵元素的最大值*/
        if(target > matrix[rows][cols]) return false;

        int currentCol = cols;
        int currentRow = 0;
        /*循环中的变化情况为，要么当前行递增，要么当前列递减*/
        while(currentCol >= 0 && currentRow <= rows) {
            if(target == matrix[currentRow][currentCol]) {
                return true;
            } else if(target < matrix[currentRow][currentCol]) {
                currentCol--;
            } else if(target > matrix[currentRow][currentCol]) {
                currentRow++;
            }
        }
        return false;
    }
}
