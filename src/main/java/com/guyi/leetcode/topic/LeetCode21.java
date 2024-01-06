package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 题目: 合并两个有序列表
 * 原题链接: https://leetcode.cn/problems/merge-two-sorted-lists/
 * 题目描述: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author 孤诣
 */
public class LeetCode21 {

    /**
     * 执行用时: 0.39%  内存占用: 83.10%
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode currentNode1 = list1;
        ListNode currentNode2 = list2;
        while (currentNode1 != null || currentNode2 != null) {
            if (currentNode1 != null) {
                list.add(currentNode1);
                currentNode1 = currentNode1.next;
            }
            if (currentNode2 != null) {
                list.add(currentNode2);
                currentNode2 = currentNode2.next;
            }
        }
        list.sort(Comparator.comparingInt(o -> o.val));
        int length = list.size();
        for (int i = 0; i < length - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    /**
     * 执行用时: 1.86%  内存占用: 72.81%
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode currentNode1 = list1;
        ListNode currentNode2 = list2;
        ListNode head = null;
        ListNode currentNode = null;
        while (true) {
            if (currentNode1 == null) {
                currentNode.next = currentNode2;
                System.out.println(currentNode2.val);
                return head;
            }
            if (currentNode2 == null) {
                currentNode.next = currentNode1;
                return head;
            }
            if (currentNode1.val <= currentNode2.val) {
                if (head == null) {
                    currentNode = currentNode1;
                    currentNode1 = currentNode1.next;
                    head = currentNode;
                    continue;
                }
                currentNode.next = currentNode1;
                currentNode1 = currentNode1.next;
                currentNode = currentNode.next;
            } else {
                if (head == null) {
                    currentNode = currentNode2;
                    currentNode2 = currentNode2.next;
                    head = currentNode;
                    continue;
                }
                currentNode.next = currentNode2;
                currentNode2 = currentNode2.next;
                currentNode = currentNode.next;
            }
        }
    }

}
