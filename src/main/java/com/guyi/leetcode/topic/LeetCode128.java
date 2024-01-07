package com.guyi.leetcode.topic;

import java.util.Arrays;

/**
 * 题目: 最长连续序列
 * 原题链接: https://leetcode.cn/problems/longest-consecutive-sequence/description/
 * <p>
 * 题目描述: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例: [100, 4, 200, 3, 2, 1]  ==> 最长连续序列长度为 4  ==> [1, 2, 3, 4]
 *
 * @author 孤诣
 */
public class LeetCode128 {

    public static void main(String[] args) {
        int[] nums = new int[]{7, -9, 3, -6, 3, 5, 3, 6, -2, -5, 8, 6, -4, -6, -4, -4, 5, -9, 2, 7, 0, 0};
        int i = longestConsecutive2(nums);
        System.out.println(i);
    }

    /**
     * 执行用时: 99.96%  内存占用: 75.84%
     */
    public static int longestConsecutive2(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0 || numsLength == 1) {
            return numsLength;
        }
        Arrays.sort(nums);
        // 当前连续序列长度 >= 1
        int currentOrderlyLength = 1;
        // 最大连续序列长度 >= 1
        int maxLength = 1;

        for (int i = 1; i < numsLength; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }

            if (nums[i - 1] == nums[i] - 1) {
                // 连续序列
                currentOrderlyLength++;
            } else {
                // 连续中断
                if (maxLength <= currentOrderlyLength) {
                    maxLength = currentOrderlyLength;
                }

                // 不论 maxLength 是否更新, currentOrderly 都要重置
                currentOrderlyLength = 1;
            }
        }

        // 出现类似 [0, 1, 2, 3] 这种情况，maxLength 将不会更新
        return Math.max(maxLength, currentOrderlyLength);
    }

}
