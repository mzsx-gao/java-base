package gao.javabase.algorithm.leetcode.array.phase3;

/**
 * @author  gaosd
 * @description ：(LeetCode-48) 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
 * 请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要 使用另一个矩阵来旋转图像。
 */
public class RotateImage_48 {

    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int maxIndex = matrix.length - 1;
        /*先沿右上 - 左下的对角线镜像翻转*/
        for (int x = 0; x <= maxIndex; ++x){
            for (int y = 0; y <= maxIndex - x; ++y){
                int temp = matrix[x][y];
                matrix[x][y] = matrix[maxIndex - y][maxIndex - x];
                matrix[maxIndex - y][maxIndex - x] = temp;
            }
        }
        /*再沿水平中线上下翻转*/
        for (int i = 0; i <= (maxIndex >> 1); ++i){
            for (int j = 0; j <= maxIndex; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[maxIndex - i][j];
                matrix[maxIndex - i][j] = temp;
            }
        }
    }
}
