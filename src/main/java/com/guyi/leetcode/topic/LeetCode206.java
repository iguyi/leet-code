package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

/**
 * 题目: 反转链表
 * 原题链接: https://leetcode.cn/problems/reverse-linked-list/description/
 * 题目描述: 给你单链表的头节点 head, 请你反转链表, 并返回反转后的链表。
 *
 * @author 孤诣
 */
public class LeetCode206 {

    /**
     * 执行用时: 100.0%  内存占用: 47.59%
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        ListNode preNode;
        ListNode nextNode;

        // 断开链表第一个节点
        preNode = currentNode;
        currentNode = currentNode.next;
        preNode.next = null;

        while (currentNode != null) {
            nextNode = currentNode.next;

            // 反转链表
            currentNode.next = preNode;

            // 移动指针
            preNode = currentNode;
            currentNode = nextNode;
        }

        return preNode;
    }

    /**
     * 执行用时: 100.0%  内存占用: 5.96%
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head.next;
        ListNode preNode = head;
        ListNode nextNode;

        preNode.next = null;

        while (currentNode != null) {
            nextNode = currentNode.next;

            // 反转链表
            currentNode.next = preNode;

            // 指针移动
            preNode = currentNode;
            currentNode = nextNode;
        }

        return preNode;
    }

}
