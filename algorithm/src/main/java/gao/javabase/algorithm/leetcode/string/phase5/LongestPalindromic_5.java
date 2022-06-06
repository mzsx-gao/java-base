package gao.javabase.algorithm.leetcode.string.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode-5) 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindromic_5 {

    public String longestPalindrome(String s) {
        int maxStart = 0, maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            /*以当前字符为中心，进行左右扩展*/
            int charCenterLen = expandAroundCenter(s, i, i);
            /*以当前字符后的空白为中心，进行左右扩展*/
            int BlackCenterLen = expandAroundCenter(s, i, i + 1);
            int len = Math.max(charCenterLen, BlackCenterLen);
            /*更新最长的回文子串的长度*/
            if (len > maxEnd - maxStart) {
                maxStart = i - (len - 1) / 2;
                maxEnd = i + len / 2;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        /*从中心，进行左右扩展判断字符是否相等，每次步进一个字符*/
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}
