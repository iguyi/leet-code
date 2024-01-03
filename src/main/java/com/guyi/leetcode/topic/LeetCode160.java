package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

/**
 * 题目: 相交链表
 * 原题连接: https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * <p>
 * 题目描述:
 * 给你两个单链表的头节点 headA 和 headB，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null。
 * 目数据 保证 整个链式结构中不存在环。
 * <p>
 * 题解: https://blog.csdn.net/iguyi/article/details/133205668
 *
 * @author 孤诣
 */
public class LeetCode160 {
    
    public static void main(String[] args) {
        LeetCode160 obj = new LeetCode160();

        // A 链表
        ListNode headA = new ListNode(1);
        ListNode nodeA1 = new ListNode(9);
        headA.next = nodeA1;
        ListNode nodeA2 = new ListNode(1);
        nodeA1.next = nodeA2;

        // C 链表  A->C  B->C
        ListNode headC = new ListNode(2);
        nodeA2.next = headC;
        ListNode nodeC1 = new ListNode(4);
        headC.next = nodeC1;

        // B 链表
        ListNode headB = new ListNode(3);
        headB.next = headC;

        ListNode intersectionNode = obj.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode == headC);

        /*// A 链表
        LeetCode160.ListNode headA = new ListNode(2);
        LeetCode160.ListNode nodeA1 = new ListNode(6);
        headA.next = nodeA1;
        LeetCode160.ListNode nodeA2 = new ListNode(4);
        nodeA1.next = nodeA2;

        // B 链表
        LeetCode160.ListNode headB = new ListNode(3);
        headB.next = new ListNode(5);

        System.out.println(obj.getIntersectionNode(headA, headB) == null);*/

        /*// A 链表
        LeetCode160.ListNode headA = new ListNode(3);

        // B 链表
        LeetCode160.ListNode headB = new ListNode(2);
        headB.next = headA;

        System.out.println(obj.getIntersectionNode(headA, headB) == headA);*/
    }

    /**
     * 执行时间: 99.14%  内存占用: 45.26
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headAIndex = headA;
        ListNode headBIndex = headB;
        while (true) {
            if (headBIndex == headAIndex) {
                return headAIndex;
            }
            headAIndex = headAIndex.next;
            headBIndex = headBIndex.next;
            if (headAIndex == null && headBIndex == null) {
                return null;
            }
            if (headAIndex == null) {
                headAIndex = headB;
            }
            if (headBIndex == null) {
                headBIndex = headA;
            }
        }
    }

}