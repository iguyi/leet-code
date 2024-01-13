package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

/**
 * 题目: 在链表中插入最大公约数
 * 原题链接: https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/description/
 * <p>
 * 题目描述:
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * 请你返回插入之后的链表。
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 * <p>
 * 例如：
 * 18-->6-->10-->3  ==>
 * 18-->[6]-->6-->[2]-->10-->[1]--3
 *
 * @author 孤诣
 */
public class LeetCode2807 {

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        ListNode current = head.next;
        current.next = new ListNode(10);
        current = current.next;
        current.next = new ListNode(3);
        current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();

        current = insertGreatestCommonDivisors(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    /**
     * 执行用时: 2 ms - 79.18%
     * 内存占用: 42.64 MB - 98.69%
     */
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head;
        ListNode newHead = new ListNode(next.val);
        ListNode current = newHead;
        int num1;
        int num2;
        int result;
        while (next.next != null) {
            num1 = next.val;
            num2 = next.next.val;
            next = next.next;
            result = greatestCommonDivisor(num1, num2);
            current.next = new ListNode(result);
            current = current.next;
            current.next = next;
            current = current.next;
        }
        return newHead;
    }

    /**
     * 辗转相除求最大公约数
     */
    public static int greatestCommonDivisor(int num1, int num2) {
        int result = 1;
        while (result != 0) {
            if (num1 > num2) {
                result = num1 % num2;
                num1 = num2;
                num2 = result;
            }
            if (num1 < num2) {
                result = num2 % num1;
                num2 = num1;
                num1 = result;
            }
            if (num1 == num2) {
                return num1;
            }
        }
        return num1 != 0 ? num1 : num2;
    }

}


