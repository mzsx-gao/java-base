package gao.javabase.algorithm.leetcode.string.phase5;

/**
 * @author  gaosd
 * @description ：(LeetCode- 165) 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。
 * 每个修订号由 多位数字 组成，可能包含 前导零 。
 * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，
 * 下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 */
public class CompareVersionNumbers_165 {

    /*使用双指针来实现*/
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int v1Length = version1.length();
        int v2Length = version2.length();
        while(i < v1Length || j < v2Length)
        {
            int num1 = 0, num2 = 0;
            /*遍历字符串，将每个小数点'.'分隔开的版本号解析成数字
            * 每解析出一位，将已有的数字*10再加上新解析出的数字*/
            while(i < v1Length && version1.charAt(i) != '.')
                num1 = num1 * 10 + version1.charAt(i++) - '0';
            while(j < v2Length && version2.charAt(j) != '.')
                num2 = num2 * 10 + version2.charAt(j++) - '0';
            if(num1 > num2) return 1;
            else if( num1 < num2) return -1;
            i++;
            j++;
        }
        return 0;
    }

    /*使用JDK的API来实现*/
    public int compareVersionWithAPI(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}
