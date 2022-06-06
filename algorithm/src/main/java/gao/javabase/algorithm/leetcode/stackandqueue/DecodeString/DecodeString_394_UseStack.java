package gao.javabase.algorithm.leetcode.stackandqueue.DecodeString;

import java.util.Stack;

/**
 * @author gaosd
 * @description ：(LeetCode-394) 字符串解码
 * 基于Stack的实现
 */
public class DecodeString_394_UseStack {

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";

        int idx = 0;
        while (idx < s.length()) {
            char cur = s.charAt(idx);
            // 处理数字
            if (Character.isDigit(cur)) {
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(s.charAt(idx))) {
                    ret.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(ret.toString()));
            }
            // 处理“[”
            else if (cur == '[') {
                resStack.push(res);
                res = "";//只把离'['最近的一个字母入栈，所以每次入栈后要把res清空
                idx++;
            }
            // 处理“]”,处理相匹配的“[”之间的字符
            else if (cur == ']') {
                StringBuffer temp = new StringBuffer(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            //处理普通字符
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}