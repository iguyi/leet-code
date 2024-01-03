package com.guyi.leetcode.topic;


import com.guyi.leetcode.common.ListNode;

/**
 * 题目: 删除链表的倒数第 N 个节点
 * 原题链接: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/submissions/468087281/
 * 题目描述: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 题解: https://blog.csdn.net/iguyi/article/details/133128920
 *
 * @author 孤诣
 */
public class LeetCode19 {

    public static void main(String[] args) {

    }

    /**
     * 双指针法
     * N = 后指针位置 - 前指针位置 + 1
     * <p>
     * 效果: 执行时间 - 100%  内存占用 - 85.09%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int counter = 1;
        ListNode frontIndex = head;
        ListNode backendIndex = head;
        ListNode frontLastNode = null;
        while (true) {
            if (counter < n) {
                counter++;
                backendIndex = backendIndex.next;
            }
            if (counter == n) {
                if (backendIndex.next == null) {
                    if (frontLastNode == null) {
                        return frontIndex.next;
                    } else {
                        frontLastNode.next = frontIndex.next;
                        return head;
                    }
                }
                backendIndex = backendIndex.next;
                frontLastNode = frontIndex;
                frontIndex = frontIndex.next;
            }
        }
    }

}
