package gao.javabase.algorithm.leetcode.dp.phase7;

/**
 * @author  gaosd
 * @description ：(LeetCode- 5) 最长回文子串
 */
public class LongestPalindromic_DP_5 {
    public String longestPalindrome(String s) {
        /*特殊用例判断，原始字符串只有1个字符和只有2个字符时*/
        int len = s.length();
        if (len == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        if(len ==2){
            if( charArray[1]==charArray[0]){
                return s;
            }else{
                return s.substring(0,1);
            }
        }
        /*记录回文子串的「长度」和「起始位置」*/
        int maxLen = 1;
        int begin = 0;

        /*dp[i][j] 表示 s[i, j] 是否是回文串*/
        boolean[][] dp = new boolean[len][len];
        /*dp[i][j]中i=j时，表示原始字符串中的每个字符，当然是回文串*/
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        /*填充dp数组，j总是要比i大*/
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    /*因为i < j，j - i < 3的取值就是1和2，j和i组成的子串包括2个字符或者3个字符
                    j和i指向的两个字符又相等，当然是回文串*/
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        /*回文串将它首尾的两个字母去除之后，它仍然是个回文串
                        * 反过来，回文串首尾加上两个一样的字符，还是个回文串
                        * 同样，非回文串首尾加上两个一样的字符，还是个非回文串*/
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                /* 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置*/
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
