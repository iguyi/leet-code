package com.guyi.leetcode.topic;

import java.util.*;

/**
 * 题目: 字母异位词分组
 * 原题链接: https://leetcode.cn/problems/group-anagrams/description/
 * 题目描述: 给你一个字符串数组，请你将 "字母异位词: 组合在一起。可以按任意顺序返回结果列表。
 * 题目解释:
 * - 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * - 两个单词的长度、组成单词的字母相同，但是排序不同
 * <p>
 * 题解: https://blog.csdn.net/iguyi/article/details/134405586
 *
 * @author 孤诣
 */
public class LeetCode49 {

    public static void main(String[] args) {
        // String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] strs = {""};
        //String[] strs = {"", "b", ""};
        String[] strs = {"stop", "pots", "reed", "", "tops", "deer", "opts", ""};

        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    /**
     * 1. 先将 "字符串数组" 中的每一个 "字符串" 转为对应的 "字符数组"
     * 2. 对 "字符数组" 中的元素进行排序，再转为 "字符串"
     * 3. 将得到的 "字符串" 作为 Map<String, List<String>> 的 key
     * <p>
     * 执行时间: 80.82%  内存占用: 75.09%
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 对字符串进行排序，作为哈希表的 key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 将当前字符串添加到对应的 value 中
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        // 将哈希表中的 value 添加到最终结果中
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

}
