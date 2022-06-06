package gao.javabase.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  gaosd
 * @description ：(LeetCode- 17) 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * 给出数字到字母的映射与电话按键相同。注意1不对应任何字母。
 */
public class LetterCombinations_17 {

    /*LeetCode官方代码*/
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        /*数字和字⺟的映射表*/
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * 对解空间树进行递归求结果集
     * @param combinations 结果集
     * @param phoneMap 数字和字⺟的映射表
     * @param src 原始只包含数字的字符串
     * @param index 对原始字符串遍历时的指针，也用以控制递归深度
     * @param combination 遍历过程中拼接的结果字符串
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String src,
                          int index, StringBuffer combination) {
        /*遍历指针和原始字符串字符串的长度一致，终止递归，并将结果字符串加入结果集*/
        if (index == src.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = src.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            /*遍历对每个数字对应的字母表，也就是处理解空间树中的非叶子节点*/
            for (int i = 0; i < lettersCount; i++) {
                char cur = letters.charAt(i);
                combination.append(cur);
                /*继续递归处理当前节点下的子节点*/
                backtrack(combinations, phoneMap, src, index + 1, combination);
                /*当前节点处理完成，往上回溯*/
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> combinations = new LetterCombinations_17().letterCombinations("23");
        System.out.println(combinations);
    }
}