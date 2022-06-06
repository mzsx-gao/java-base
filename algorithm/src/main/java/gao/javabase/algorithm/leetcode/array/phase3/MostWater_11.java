package gao.javabase.algorithm.leetcode.array.phase3;

/**
 * @author  gaosd
 * @description ：(LeetCode-11) 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class MostWater_11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxWater = 0;
        while(i < j) {
            /* height[i]和height[j]，谁小就移动谁*/
            maxWater = height[i] < height[j] ?
                    Math.max(maxWater, (j - i) * height[i++]):
                    Math.max(maxWater, (j - i) * height[j--]);
        }
        return maxWater;
    }
}
