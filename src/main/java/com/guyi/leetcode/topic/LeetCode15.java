package com.guyi.leetcode.topic;

import java.util.*;

/**
 * 题目: 三数之和
 * 原题链接: https://leetcode.cn/problems/3sum/description/
 * <p>
 * 题目描述:
 * 给你一个整数数组 nums, 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、 i != k 且 j != k, 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author 孤诣
 */
public class LeetCode15 {

    /**
     * 暴力破解, 超时
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> tempList;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (y == x) {
                    continue;
                }
                for (int z = 0; z < length; z++) {
                    if (z == x || z == y) {
                        continue;
                    }
                    if (nums[x] + nums[y] + nums[z] == 0) {
                        tempList = Arrays.asList(nums[x], nums[y], nums[z]);
                        tempList.sort(Comparator.comparingInt(num -> num));
                        result.add(tempList);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 排序 + 双指针
     * 执行时间: 27.43%  内存占有: 85.47%
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        // 先排序
        Arrays.sort(nums);

        // 存放返回结果
        List<List<Integer>> result = new ArrayList<>();

        /*
            用三个变量分别表示 current、frontIndex、backIndex 某个三元组在数组中的位置
            current 记录当前遍历到的元素
        */
        int current = 0;
        int frontIndex = 1;
        int length = nums.length;
        int backIndex = length - 1;

        // 存放 num[i] + num[j] + num[k] 的结果
        int sum;

        // 遍历数组
        while (current < length - 1) {
            while (frontIndex < backIndex) {
                sum = nums[current] + nums[frontIndex] + nums[backIndex];
                if (sum == 0) {
                    // 符合题目要求
                    result.add(Arrays.asList(nums[current], nums[frontIndex], nums[backIndex]));
                    while (frontIndex < backIndex && nums[frontIndex] == nums[frontIndex + 1]) {
                        frontIndex++;
                    }
                    while (backIndex > frontIndex && nums[backIndex] == nums[backIndex - 1]) {
                        backIndex--;
                    }
                    frontIndex++;
                    backIndex--;
                } else if (sum < 0) {
                    frontIndex++;
                } else {
                    backIndex--;
                }
            }
            while (current < length - 2 && nums[current] == nums[current + 1]) {
                current++;
            }
            frontIndex = ++current + 1;
            backIndex = length - 1;
        }
        return result;
    }

}
