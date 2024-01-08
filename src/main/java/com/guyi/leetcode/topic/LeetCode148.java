package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 题目: 排序链表
 * 原题链接: https://leetcode.cn/problems/sort-list/
 * 题目描述: 给你链表的头结点 head, 请将其按升序排列并返回 排序后的链表。
 *
 * @author 孤诣
 */
public class LeetCode148 {

    /**
     * 执行时间: 37.70%  内存占用: 77.17%
     */
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        int length = list.size();
        if (length == 0) {
            return null;
        } else {
            list.sort(Comparator.comparingInt(node -> node.val));
            for (int i = 0; i < length - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            list.get(length - 1).next = null;
            return list.get(0);
        }
    }

}
