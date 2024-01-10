package com.guyi.leetcode.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 题目: 丢失的数据
 * 原题链接: https://leetcode.cn/problems/missing-number/description/
 * 题目描述: 给定一个包含 [0, n] 中 n 个数的数组 nums, 找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * @author 孤诣
 */
public class LeetCode268 {

    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{0, 3, 1}));

        System.out.println(missingNumber2(new int[]{0, 3, 1}));

        System.out.println(missingNumber3(new int[]{0, 3, 1}));
    }

    public static int missingNumber1(int[] nums) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            Collections.addAll(arrayList, num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!arrayList.contains(i)) {
                return i;
            }
        }

        return nums.length;
    }

    public static int missingNumber2(int[] nums) {
        int length = nums.length;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == nums[j]) {
                    break;
                }
                if (j == length - 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return length;
    }

    public static int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int missingNumber = 0;
        for (int num : nums) {
            if (missingNumber != num) {
                return missingNumber;
            }
            missingNumber++;
        }
        return missingNumber;
    }

}
