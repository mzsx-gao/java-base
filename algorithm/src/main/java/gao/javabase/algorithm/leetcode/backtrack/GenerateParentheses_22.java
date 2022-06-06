package gao.javabase.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode- 22) 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParentheses_22 {

    /*LeetCode官方代码*/
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     * @param ans  结果集
     * @param cur 结果字符串，完成后会加入结果集
     * @param left 左括号的已使用数量
     * @param right 右括号的已使用数量
     * @param max 最大数
     */
    public void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        /*所有左右括号全部使用完，终止递归，并将结果字符串加入结果集*/
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        /*处理左子树*/
        if (left < max) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        /*处理右子树，但是需要剪枝，结果字符串左括号的个数比右括号大的时候才有意义*/
        if (right < left) {
            cur.append(')');
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses_22().generateParenthesis(2));
    }
}