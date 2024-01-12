package com.guyi.leetcode.topic;

/**
 * 题目: 根据给定数据划分数组
 * 原题链接: https://leetcode.cn/problems/partition-array-according-to-given-pivot/description/
 * <p>
 * 题目描述:
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 pivot。请你将 nums 重新排列，使得以下条件均成立：
 * 1. 所有小于 pivot 的元素都出现在所有大于 pivot 的元素之前 。
 * 2. 所有等于 pivot 的元素都出现在小于和大于 pivot 的元素中间 。
 * 3. 小于 pivot 的元素之间和大于 pivot 的元素之间的相对顺序不发生改变。
 * 4. 更正式的, 考虑每一对 pi、pj: pi 是初始时位置 i 元素的新位置, pj 是初始时位置 j 元素的新位置。
 * 对于小于 pivot 的元素, 如果 i < j 且 nums[i] < pivot 和 nums[j] < pivot 都成立, 那么 pi < pj 也成立。
 * 类似的, 对于大于 pivot 的元素, 如果 i < j 且 nums[i] > pivot 和 nums[j] > pivot 都成立, 那么 pi < pj。
 * <p>
 * 请你返回重新排列 nums 数组后的结果数组。
 *
 * @author 孤诣
 */
public class LeetCode2161 {

    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int[] ints = pivotArray(nums, 10);
        for (int num : ints) {
            System.out.print(num + " ");
        }

        System.out.println();

        nums = new int[]{-3, 4, 3, 2};
        ints = pivotArray(nums, 2);
        for (int num : ints) {
            System.out.print(num + " ");
        }
    }

    /**
     * 执行用时: 5 ms - 55.88%
     * 内存占用: 64.90 MB - 54.90%
     */
    public static int[] pivotArray(int[] nums, int pivot) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int[] result = new int[nums.length];
        int[] ltPivots = new int[nums.length];
        int[] eqPivots = new int[nums.length];
        int[] gtPivots = new int[nums.length];
        int ltIndex = 0;
        int eqIndex = 0;
        int gtIndex = 0;
        for (int num : nums) {
            if (num < pivot) {
                ltPivots[ltIndex++] = num;
                continue;
            }
            if (num == pivot) {
                eqPivots[eqIndex++] = num;
                continue;
            }
            gtPivots[gtIndex++] = num;
        }
        int resultIndex = 0;
        for (int i = 0; i < ltIndex; i++) {
            result[resultIndex++] = ltPivots[i];
        }
        for (int i = 0; i < eqIndex; i++) {
            result[resultIndex++] = eqPivots[i];
        }
        for (int i = 0; i < gtIndex; i++) {
            result[resultIndex++] = gtPivots[i];
        }
        return result;
    }

    /**
     * 执行用时: 4 ms - 94.12%
     * 内存占用: 64.19 MB - 35.29%
     */
    public static int[] pivotArray2(int[] nums, int pivot) {
        int count = nums.length;
        if (count == 0 || count == 1) {
            return nums;
        }
        int[] result = new int[count];
        int index = 0;
        for (int j : nums) {
            if (j < pivot) {
                result[index++] = j;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }
        return result;
    }

}
