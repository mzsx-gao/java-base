package gao.javabase.algorithm.leetcode.stackandqueue.phase4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author  gaosd
 * @description ：(LeetCode-224) 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 */
public class BasicCalculator_224 {

    public int calculate(String s) {
        /*存放当前的计算结果*/
        int result = 0;
        /*存放当前待计算数字*/
        int num = 0;
        /*符号，加号(+1)或者减号(-1)*/
        int sign = 1;
        Deque<Integer> stack = new LinkedList<Integer>();

        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            char c = chars[i];
            /*如果当前字符为' '，无需处理*/
            if (c == ' ') {
                continue;
            }
            /*如果当前字符是一个数字，则用num进行记录，当然需要考虑到数字不止一位
            所以 num = num * 10 + c - '0'*/
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                /*判断当前数字是否已经取完，只要后续字符在'0'到'9'之间，说明当前数字还未结束*/
                if (i < len - 1 && '0' <= chars[i + 1] && chars[i + 1] <= '9') {
                    continue;
                }
            /*如果当前字符为计算符号*/
            } else if (c == '+' || c == '-') {
                num = 0;
                sign = c == '+' ? 1 : -1;
            /*如果当前符号为'('，需要将前面的计算结果和符号入栈*/
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            /*如果当前符号为')'，括号里的表达式已经计算完成了，
            可以和括号外的结果进行合并计算了*/
            } else if (c == ')') {
                /*计算符号出栈*/
                sign = stack.pop();
                /*将num替换为括号中的计算结果*/
                num = result;
                /*将result替换为括号前边的计算结果*/
                result = stack.pop();
            }
            /*每循环一次，得到一个新的结果*/
            result += sign * num;
        }
        return result;
    }
}
