package gao.javabase.algorithm.leetcode.string.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode-76) 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class MinWindowSubstring_76 {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        /*s 和 t 由英文字母组成，所以128个够用了*/
        int[] tChars = new int[128];
        /*用字符串t的字符初始化字典tChars，记录每个字符出现的次数*/
        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i)]++;
        }
        /*left是窗口当前左边界，right是窗口当前右边界*/
        int left = 0, right = 0;
        /*size记录满足条件的窗口大小，count是需求的字符个数*/
        int size = Integer.MAX_VALUE, count = t.length();
        /*start是最小覆盖串开始的index*/
        int start = 0;
        /*遍历所有字符*/
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tChars[c] > 0) {/*需要当前字符c*/
                count--;
            }
            /*当前字符在tChars中的次数减一，这个次数可以为负数
            * 比如当前字符在s中存在，在t中不存在
            * 或者当前窗口范围内，在s中出现的次数大于t中出现的次数*/
            tChars[c]--;
            /*窗口中已经包含所有字符*/
            if (count == 0) {
                /*左边界向右递增，滑动窗口开始缩减,字典tChars要进行复原
                * 缩减的停止处就是窗口内的字符集合刚好包含了t的全部字符，类似于示例 1中窗口包含了"BANC"
                * 如果字典tChars的某个字符个数小于0，说明要么当前字符在s中存在，在t中不存在
                * 要么当前窗口范围内，在s中出现的次数大于t中出现的次数*/
                while (left < right && tChars[s.charAt(left)] < 0) {
                    tChars[s.charAt(left)]++;
                    left++;
                }
                /*更新size的最小值*/
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;/*记录下最小值时候的开始位置，最后返回覆盖串时候会用到*/
                }
                /*left向右移动后窗口肯定不能满足了重新开始循环*/
                tChars[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
