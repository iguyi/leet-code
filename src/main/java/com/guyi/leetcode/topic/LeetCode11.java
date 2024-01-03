package com.guyi.leetcode.topic;

/**
 * 题目: 盛水最多的容器
 * 原题链接: https://leetcode.cn/problems/container-with-most-water/
 * <p>
 * 题目描述:
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * <p>
 * 题解: https://blog.csdn.net/iguyi/article/details/133182109
 *
 * @author 孤诣
 */
public class LeetCode11 {

    public static void main(String[] args) {
        // 49
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(height));

        // 1
        height = new int[]{1, 1};
        System.out.println(maxArea1(height));

        // 2
        height = new int[]{1, 1, 1};
        System.out.println(maxArea1(height));
    }

    /**
     * 双指针
     */
    public static int maxArea1(int[] height) {
        int maxValue = 0;
        int currentMinHeight;
        for (int frontIndex = 0, backendIndex = height.length - 1; frontIndex != backendIndex; ) {
            currentMinHeight = Math.min(height[frontIndex], height[backendIndex]);
            if (height[backendIndex] <= height[frontIndex]) {
                maxValue = Math.max(maxValue, (backendIndex - frontIndex) * currentMinHeight);
                backendIndex--;
            } else {
                maxValue = Math.max(maxValue, (backendIndex - frontIndex) * currentMinHeight);
                frontIndex++;
            }
        }
        return maxValue;
    }

    /**
     * 双指针
     * if...else... 换为 三目运算
     * 时间更久了，但是内存占用少了一点(很少)，不如不用
     */
    public static int maxArea2(int[] height) {
        int maxValue = 0;
        for (int frontIndex = 0, backendIndex = height.length - 1; frontIndex != backendIndex; ) {
            maxValue = height[backendIndex] <= height[frontIndex]
                    ? Math.max(maxValue
                    , (backendIndex - frontIndex) * Math.min(height[frontIndex], height[backendIndex--]))
                    : Math.max(maxValue
                    , (backendIndex - frontIndex) * Math.min(height[frontIndex++], height[backendIndex]));
        }
        return maxValue;
    }

}
