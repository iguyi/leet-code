package com.guyi.leetcode.topic;

import java.util.Arrays;

/**
 * 题目: 移动零
 * 原题链接: https://leetcode.cn/problems/move-zeroes/
 * <p>
 * 题目描述:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 题解: https://blog.csdn.net/iguyi/article/details/134011065
 *
 * @author 孤诣
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 3, 0, 12};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针解法
     * 执行用时: 100.0%  内存占用: 58.39
     */
    public static void moveZeroes1(int[] nums) {
        int numsLength = nums.length;
        // 指向第一个 0 的位置
        int index = -1;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] != 0 && index != -1) {
                nums[index++] = nums[i];
                nums[i] = 0;
                continue;
            }
            if (nums[i] == 0 && index == -1) {
                index = i;
            }
        }
    }

}
