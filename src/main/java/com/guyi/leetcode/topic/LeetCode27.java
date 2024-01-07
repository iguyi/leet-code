package com.guyi.leetcode.topic;

import java.util.Arrays;

/**
 * 题目: 移除元素
 * 原题链接:https://leetcode.cn/problems/remove-element/description/
 * <p>
 * 题目描述:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * - 给定参数: nums=[3,2,3,1]  val=3 ==> 目标输出 [2,1] --> 长度是 2
 * - 程序只需要保证将 nums=[3,2,3,1]  ==> nums=[2,1,...]即可, 即保证前2个元素和目标输出一致, 并不是真的让数组变成[2,1]
 *
 * @author 孤诣
 */
public class LeetCode27 {

    public static void main(String[] args) {
        int[] x = new int[]{3, 2, 3, 1};
        int i = removeElement(x, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(x));
    }

    /**
     * 执行用时: 100.0%  内存占用: 60.69%
     */
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        return index;
    }

}
