package com.guyi.leetcode.topic;

import java.util.HashMap;


/**
 * 题目: 和为 k 的子数组
 * 原题链接: https://leetcode.cn/problems/subarray-sum-equals-k/description/
 * <p>
 * 题目描述:
 * - 给你一个整数数组 nums 和一个整数 k, 请你统计并返回该数组中和为 k 的连续子数组的个数。
 * - 子数组是数组中元素的连续非空序列。
 *
 * @author 孤诣
 */
public class LeetCode560 {

    public static void main(String[] args) {
        System.out.println("预期结果: 2 实际结果: " + subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println("预期结果: 2 实际结果: " + subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println("预期结果: 5 实际结果: " + subarraySum(new int[]{1, 2, 3, 6, 3, 1, 4, 1, 2, 3}, 3));
        System.out.println("预期结果: 3 实际结果: " + subarraySum(new int[]{1, -1, 0}, 0));
        System.out.println("预期结果: 4 实际结果: " + subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }

    /**
     * 前缀和 （元素中存在负数，不能使用双指针或滑动窗口）
     * <p>
     * 执行用时: 27 ms - 49.35%
     * 内存占用: 44.60 MB - 57.99%
     */
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int pre = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (hashMap.containsKey(pre - k)) {
                result += hashMap.get(pre - k);
            }
            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }
        return result;
    }

}
