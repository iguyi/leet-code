package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 题目: 环形链表
 * 原题链接: https://leetcode.cn/problems/linked-list-cycle/
 * <p>
 * 题目描述:
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 题解: https://blog.csdn.net/iguyi/article/details/133417203
 *
 * @author 孤诣
 */
public class LeetCode141 {

    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     * 执行时间: 100%   内存占用: 30.76%
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希表
     * 执行时间: 13.61%  内存占用: 83.1%
     */
    public boolean hasCycle2(ListNode head) {
        ListNode currentNode = head;
        HashSet<ListNode> hash = new HashSet<>();
        while (currentNode != null) {
            if (hash.contains(currentNode)) {
                return true;
            }
            hash.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * 哈希表 - 优化hasCycle3(), 将 HashSet 替换为 HashMap, 减少内存占用
     * 执行时间: 13.61%  内存占用: 94.40%
     */
    public boolean hasCycle3(ListNode head) {
        ListNode currentNode = head;
        Map<ListNode, Object> hash = new HashMap<>();
        while (currentNode != null) {
            if (hash.containsKey(currentNode)) {
                return true;
            }
            hash.put(currentNode, null);
            currentNode = currentNode.next;
        }
        return false;
    }

}
