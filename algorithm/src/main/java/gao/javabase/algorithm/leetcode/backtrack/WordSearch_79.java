package gao.javabase.algorithm.leetcode.backtrack;

/**
 * @author  gaosd
 * @description ：(LeetCode- 79) 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class WordSearch_79 {

//    /*LeetCode官方解法*/
//    public boolean exist(char[][] board, String word) {
//        int h = board.length, w = board[0].length;
//        boolean[][] visited = new boolean[h][w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                boolean flag = check(board, visited, i, j, word, 0);
//                if (flag) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
//        if (board[i][j] != s.charAt(k)) {
//            return false;
//        } else if (k == s.length() - 1) {
//            return true;
//        }
//        visited[i][j] = true;
//        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        boolean result = false;
//        for (int[] dir : directions) {
//            int newi = i + dir[0], newj = j + dir[1];
//            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
//                if (!visited[newi][newj]) {
//                    boolean flag = check(board, visited, newi, newj, s, k + 1);
//                    if (flag) {
//                        result = true;
//                        break;
//                    }
//                }
//            }
//        }
//        visited[i][j] = false;
//        return result;
//    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int x=0; x<board.length; x++) {
            for (int y=0; y<board[x].length; y++) {
                if (backTrack(board, x, y, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int x, int y, char[] word, int currLength) {
        if (currLength == word.length) return true;
        /*矩阵越界检查*/
        if (x<0 || y<0 || x == board.length || y == board[x].length) return false;
        /*当前字母和单词中的不匹配*/
        if (board[x][y] != word[currLength]) return false;
        /*当前元素进行异或用来标识已经访问过
        * char在Java中默认是两个字节，所以不会有位溢出风险*/
        board[x][y] ^= 256;
        /*按照右、下、左、上的顺序进行试探*/
        boolean exist = backTrack(board, x, y+1, word, currLength+1)
                || backTrack(board, x-1, y, word, currLength+1)
                || backTrack(board, x+1, y, word, currLength+1)
                || backTrack(board, x, y-1, word, currLength+1);
        /*回溯，再次异或,复原原来的元素值*/
        board[x][y] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        new WordSearch_79().exist(new char[][]{{'A','B','C','E'},
                {'S','F','C','S'},{'A','D','E','E'}},"ABCCED");
    }
}
