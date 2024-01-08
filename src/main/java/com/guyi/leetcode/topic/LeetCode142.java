package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目: 环形了Ⅱ
 * 原题链接: https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * <p>
 * 题目描述:
 * 给定一个链表的头节点  head, 返回链表开始入环的第一个节点。如果链表无环, 则返回 null。
 * 如果链表中有某个节点, 可以通过连续跟踪 next 指针再次到达, 则链表中存在环。
 * 为了表示给定链表中的环, 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1, 则在该链表中没有环。
 * 注意: pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * @author 孤诣
 */
public class LeetCode142 {

    /**
     * 执行用时: 5.65%  内存占用: 36.46%
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        int index = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            if (map.containsKey(currentNode)) {
                return currentNode;
            } else {
                map.put(currentNode, index++);
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    /**
     * 执行用时: 18.53%  内存占用: 99.39%
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            if (hashSet.contains(currentNode)) {
                return currentNode;
            } else {
                hashSet.add(currentNode);
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    /**
     * 执行用时: 100.00%  内存占用: 48.02%
     */
    public ListNode detectCycle3(ListNode head) {
        if (head == null) {
            return null;
        }

        // 快、慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            slow = slow.next;
            if (slow == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
                if (fast == null) {
                    return null;
                }
            }
            if (slow == fast) {
                slow = head;
                break;
            }
        }
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }

}
