package com.guyi.leetcode.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 题目: 找到字符串中所有字母异位词
 * 原题链接: https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 * <p>
 * 题目描述:
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到数组的末尾, 同时保持非零元素的相对顺序。
 * 请注意, 必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author 孤诣
 */
public class LeetCode438 {

    /**
     * 执行用时: 1117 ms - 13.89%
     * 内存占用: 44.14 MB - 18.37%
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> beginIndexList = new ArrayList<>();
        if (s.length() < p.length()) {
            return beginIndexList;
        }
        byte[] pItems = p.getBytes();
        Arrays.sort(pItems);
        p = new String(pItems);

        String temp;
        byte[] tempArray;
        for (int beginIndex = 0, endIndex = beginIndex + p.length(); endIndex != s.length() + 1; ) {
            temp = s.substring(beginIndex, endIndex++);
            tempArray = temp.getBytes();
            Arrays.sort(tempArray);
            temp = new String(tempArray);
            if (p.equals(temp)) {
                beginIndexList.add(beginIndex);
            }
            beginIndex++;
        }
        return beginIndexList;
    }

}
