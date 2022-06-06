package gao.javabase.algorithm.leetcode.dp;

/**
 * @author  gaosd
 * @description ：辅助类
 */
public class Tools {

    /*打印一维数组*/
    public static void printRow(int[] calcArray){
        int arrayY = 0;
        for(int j:calcArray){
            System.out.print("["+arrayY+++"]="+j+", ");
        }
        System.out.println("");
    }

    /*打印二维数组*/
    public static void printTwoDimeArray(int[][] calcArray){
        int arrayX = 0;
        for(int[] row:calcArray){
            System.out.print("["+arrayX+++"]: ");
            printRow(row);
        }
        System.out.println("-----------------------------");
    }
}
