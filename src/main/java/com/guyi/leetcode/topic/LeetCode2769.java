package com.guyi.leetcode.topic;

/**
 * 题目: 找出最大的可达成数字
 * 原题链接: https://leetcode.cn/problems/find-the-maximum-achievable-number/description/
 * <p>
 * 题目描述:
 * 给你两个整数 num 和 t 。
 * 如果整数 x 可以在执行下述操作不超过 t 次的情况下变为与 num 相等, 则称其为 可达成数字:
 * 每次操作将 x 的值增加或减少 1, 同时可以选择将 num 的值增加或减少 1 。
 * <p>
 * 返回所有可达成数字中的最大值。可以证明至少存在一个可达成数字。
 *
 * @author 孤诣
 */
public class LeetCode2769 {

    /**
     * 执行用时: 1 ms - 100.00%
     * 内存占用: 39.13 MB - 77.36%
     */
    public int theMaximumAchievableX01(int num, int t) {
        return num + 2 * t;
    }

}
