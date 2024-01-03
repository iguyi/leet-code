package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

/**
 * 题目: 两两交换链表中的节点
 * 原题链接: https://leetcode.cn/problems/swap-nodes-in-pairs/
 * 题目描述: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例: 1->2->3->4  ==> 2->1->4->3
 * 题解: https://blog.csdn.net/iguyi/article/details/133254014
 *
 * @author 孤诣
 */
public class LeetCode24 {
    public static void main(String[] args) {

    }

    /**
     * 方式一: 遍历链表
     * frontIndex.next = backendIndex.next;
     * backend.next = frontIndex;
     * frontLastIndex.next = backendIndex;
     * <p>
     * 为了能够正确完成节点之间的连接关系，实际需要四个变量来分别记录:
     * 前指针指向节点
     * 前指针指向节点的上一个节点
     * 后指针指向节点
     * 后指针指向节点的下一个节点
     * <p>
     * 执行时间: 100%  内存占用: 31.64%
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultHead = null;
        ListNode frontIndex = head;
        ListNode backendIndex = head.next;
        ListNode last = null;
        ListNode next = backendIndex.next;
        while (true) {
            if (resultHead == null) {
                resultHead = backendIndex;
            }
            backendIndex.next = frontIndex;
            frontIndex.next = next;
            if (last != null) {
                last.next = backendIndex;
            }

            last = frontIndex;
            frontIndex = next;
            if (frontIndex == null) {
                break;
            }
            if (frontIndex.next == null) {
                break;
            }
            backendIndex = frontIndex.next;
            next = backendIndex.next;
        }
        return resultHead;
    }

    /**
     * 方式二: 虚拟节点+遍历链表
     * 创建一个虚拟节点，让其指向原链表的头节点, 此时会得到一条新的链表，其头节点是刚创建的虚拟节点。
     * 使用 temp 变量作为遍历指针，从虚拟节点开始遍历链表。
     * 前指针: frontIndex = temp.next;
     * 后指针: backendIndex = temp.next.next;
     * 每循环一次，就执行
     * temp.next = backend;
     * frontIndex.next = backendIndex.next;
     * backendIndex.next = frontIndex;
     * 然后更新 temp: temp = temp.next.next;
     * 最后只要返回虚拟节点的下一个节点即可。
     * <p>
     * 执行时间: 100%  内存占用: 68.96%
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        ListNode frontIndex;
        ListNode backendIndex;
        while (temp.next != null && temp.next.next != null) {
            frontIndex = temp.next;
            backendIndex = temp.next.next;
            temp.next = backendIndex;
            frontIndex.next = backendIndex.next;
            backendIndex.next = frontIndex;
            temp = temp.next.next;
        }
        return dummyHead.next;
    }

}
