package gao.javabase.algorithm.leetcode.string.phase5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  gaosd
 * @description ：(LeetCode- 3) 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstring_3 {

    /*LeetCode官方解法，使用HashSet判断是否有重复的字符*/
    public int lengthOfLongestSubstringWithHash(String s) {
        /*哈希集合，记录每个字符是否出现过*/
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        /*右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动*/
        int rk = -1, ans = 0;
        /*遍历字符串，i代表左指针*/
        for (int i = 0; i < n; ++i) {
            /*i = 0,hash集合中还没有字符，自然就不需要移除*/
            if (i != 0) {
                /*左指针向右移动一格，移除一个字符*/
                occ.remove(s.charAt(i - 1));
            }
            /*i = 0时，rk + 1=0，从字符串第0个字符开始*/
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                /*不断地移动右指针*/
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            /*第 i 到 rk 个字符是一个极长的无重复字符子串*/
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /*使用HashMap优化*/
    public int lengthOfLongestSubstringWithMap(String s) {
        /*map用来记录每个字符的最近一次的索引*/
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        /*end负责遍历整个字符串*/
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                /*如果map中已经包含当前字符，说明出现了重复，
                将start位置跳转到当前字符上一次出现位置+1，比如："abcabcdbb"
                0 1 2 3 4 5 6 7 8
                a b c a b c d b b
                      ^       ^
                    start    end
                end=7,start=3，这个时候start可以直接跳至 5*/
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestSubstring_3().lengthOfLongestSubstringWithMap("abcabcdbb");
    }

}
