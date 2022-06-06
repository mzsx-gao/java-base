package gao.javabase.algorithm.leetcode.string.phase5;

import java.util.*;

/**
 * @author  gaosd
 * @description ：(LeetCode- 151) 翻转字符串里的单词
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 */
public class ReverseWords_151 {

    /*使用JDK中的api*/
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /*LeetCode的官方解法，使用了栈的思路来实现*/
    public String reverseWordsWithStack(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    /*倒着遍历原始字符串s*/
     public String reverseWordsWithBack(String s) {
         char[] charArray = s.toCharArray();
         /*left用以排除字符串s开始的空格，最终定位到s中第一个字母*/
         int left = 0;
         /*right用以排除字符串s后面的空格，最终定位到s中最后一个字母
         * 而且right会在s中倒着遍历字符串的单词*/
         int right = charArray.length-1;
         StringBuilder sb = new StringBuilder();
         /*排除字符串s前后空格*/
         while(charArray[left]==' ') left++;
         while(charArray[right] == ' ') right--;

         /*开始倒序遍历字符串*/
         while(left <= right){
             /*index用以倒序遍历字符串中的字母*/
             int index = right;
             while(index >= left && charArray[index] != ' ' )
                 index--;
             /*遇见单词前的空格，取出单词，单词的范围就是index+1~right*/
             for(int i = index+1 ; i <= right ; i++ )
                 sb.append( charArray[i] );
             if(index > left)
                 sb.append(' ');
             /*单词之间可能有多个空格，排除*/
             while( index >= left && charArray[index]==' ' )
                 index--;
             /*遇见了新单词，重复开始处理*/
             right = index;
         }
         return sb.toString();
     }

}
