package com.guyi.leetcode.common;

/**
 * Leet Code 列表相关题目通用 ListNode 类
 *
 * @author 孤诣
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}