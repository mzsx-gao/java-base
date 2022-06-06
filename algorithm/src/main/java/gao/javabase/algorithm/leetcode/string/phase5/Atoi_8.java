package gao.javabase.algorithm.leetcode.string.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode-8)  字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，
 * 使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 */
public class Atoi_8 {

    public int myAtoi(String s) {
        int len = s.length();
        /*因为要逐个字符处理，先转换为字符数组*/
        char[] charArray = s.toCharArray();
        int idx = 0;

        /*1、检查是否空格*/
        while (idx < len && charArray[idx] == ' ') {
            idx++;
        }

        /*2、idx和字符串的长度相等，说明字符串全部是空格*/
        if (idx == len) {
            return 0;
        }

        /*3、此时idx指向为第一个非空格字符，idx前面字符均可忽略
        如果出现符号字符，用sign记录正负*/
        int sign = 1;
        char firstChar = charArray[idx];
        if (firstChar == '+') {
            idx++;
        } else if (firstChar == '-') {
            idx++;
            sign = -1;
        }

        /*4、读取后续出现的数字字符并进行转换*/
        int result = 0;
        while (idx < len) {
            char currentChar = charArray[idx];
            /*出现了'0'~'9'之外的字符终止循环，比如示例4：“words and 987”，会直接返回0*/
            if (currentChar > '9' || currentChar < '0') {
                break;
            }

            /*只能存储 32 位大小的有符号整数，
            如果在已有数字的基础上*10再加上当前数字，很有可能溢出，
            需要提前判断乘以 10 以后是否溢出,
            result>Integer.MAX_VALUE/10用以判断result本身乘以 10是否溢出
            (result == Integer.MAX_VALUE / 10 && (currentChar - '0') > Integer.MAX_VALUE % 10)
            用以判断result本身乘以10后的个位数部分，是否可以容纳下当前数字，当然直接写数字7也可以，
            比如：(result == Integer.MAX_VALUE / 10 && (currentChar - '0') > 7
            */
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && (currentChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            /*和上面代码的意义一致
            if中后面的条件也可以改成(result == Integer.MIN_VALUE / 10 && (currentChar - '0') > 8
            */
            if (result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && (currentChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            /*转换，并更新result，准备处理下一个字符*/
            result = result * 10 + sign * (currentChar - '0');
            idx++;
        }
        return result;
    }

    public static void main(String[] args) {
        Atoi_8 atoi_8 = new Atoi_8();
        System.out.println(atoi_8.myAtoi("words and 987"));
    }
}
