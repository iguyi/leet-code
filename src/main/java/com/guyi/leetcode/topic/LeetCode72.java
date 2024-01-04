package com.guyi.leetcode.topic;

import java.util.Objects;

/**
 * 题目: 最短距离
 * 原题链接: https://leetcode.cn/problems/edit-distance/description/
 * <p>
 * 题目描述:
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * - 插入一个字符
 * - 删除一个字符
 * - 替换一个字符
 *
 * @author 孤诣
 */
public class LeetCode72 {

    public static void main(String[] args) {
        // 3
        System.out.println(minDistance("horse", "ros"));

        // 5
        System.out.println(minDistance("intention", "execution"));
    }

    /**
     * 执行时间: 11.22%  内存占用: 43.83%
     */
    public static int minDistance(String word1, String word2) {
        byte[] current = word1.getBytes();
        byte[] other = word2.getBytes();

        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int[][] d = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int leftDown = d[i - 1][j - 1];
                if (!Objects.equals(current[i - 1], other[j - 1])) {
                    leftDown += 1;
                }
                d[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }

        return d[n][m];
    }

}
