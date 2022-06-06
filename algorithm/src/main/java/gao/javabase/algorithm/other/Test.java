package gao.javabase.algorithm.other;

/**
 * 名称: Test
 * 描述: 写一个算法判断一个英文单词的所有字母是否全都不同（不区分大小写）
 *
 * @author gaoshudian
 * @date 11/17/21 3:45 PM
 */
public class Test {

    public static boolean judge(String str) {
        String temp = str.toLowerCase();
        int[] letterCounter = new int[26];//数组存放26个英文字母的位置，
        for (int i = 0; i < temp.length(); i++) {
            int index = temp.charAt(i) - 'a';
            letterCounter[index]++;
            if (letterCounter[index] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(judge("hello"));
        System.out.print(judge("smile"));
    }

}