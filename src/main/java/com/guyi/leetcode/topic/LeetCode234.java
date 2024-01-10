package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目: 回文链表
 * 原题链接: https://leetcode.cn/problems/palindrome-linked-list/description/
 * 题目描述: 给你一个单链表的头节点 head, 请你判断该链表是否为回文链表。如果是, 返回 true; 否则, 返回 false。
 *
 * @author 孤诣
 */
public class LeetCode234 {

    public static void main(String[] args) {
        LeetCode234 obj = new LeetCode234();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("预期输出: true, 实际输出: " + obj.isPalindrome1(node1));
        System.out.println("预期输出: false, 实际输出: " + obj.isPalindrome1(node3));

        System.out.println("预期输出: true, 实际输出: " + obj.isPalindrome2(node1));
        System.out.println("预期输出: false, 实际输出: " + obj.isPalindrome2(node3));
    }

    /**
     * 执行用时: 67.18%  内存占用: 66.59%
     */
    public boolean isPalindrome1(ListNode head) {
        // 各个节点存入 List 中
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }

        // 头尾指针法
        int size = list.size();
        for (int currentHeadIndex = 0, currentTailIndex = size - 1; currentHeadIndex < currentTailIndex; ) {
            if (list.get(currentHeadIndex++).val != list.get(currentTailIndex--).val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时: 38.14%  内存占用: 90.45%
     */
    public boolean isPalindrome2(ListNode head) {
        // 各个节点的数据存入 List 中
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 头尾指针法
        int size = list.size();
        for (int currentHeadIndex = 0, currentTailIndex = size - 1; currentHeadIndex < currentTailIndex; ) {
            if (!list.get(currentHeadIndex++).equals(list.get(currentTailIndex--))) {
                return false;
            }
        }
        return true;
    }

}
