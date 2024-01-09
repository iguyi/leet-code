package com.guyi.leetcode.topic;

/**
 * 题目: 最小栈
 * 原题链接: https://leetcode.cn/problems/min-stack/description/
 * <p>
 * 题目描述: 设计一个支持 push, pop, top 操作, 并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * - MinStack() 初始化堆栈对象。
 * - void push(int val) 将元素val推入堆栈。
 * - void pop() 删除堆栈顶部的元素。
 * - int top() 获取堆栈顶部的元素。
 * - int getMin() 获取堆栈中的最小元素。
 * <p>
 * 提示：不会在空栈上进行 pop、top、getMin 操作
 *
 * @author 孤诣
 */
public class LeetCode155 {
}

/**
 * 使用单向链表实现栈
 * 执行时间: 100%  内存占用: 77.82%
 */
class MinStack {

    private Node node;

    /**
     * 栈顶元素
     */
    private Node head;

    /**
     * 栈底元素
     */
    private Node tail;

    /**
     * 最小元素
     */
    private Node min;

    public MinStack() {
    }

    /**
     * 压栈
     *
     * @param val - 数据
     */
    public void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            tail = newNode;
            head = newNode;
            min = newNode;
            return;
        }
        newNode.nextNode = head;
        if (newNode.data <= min.data) {
            newNode.nextMin = min;
            min = newNode;
        }
        head = newNode;
    }

    /**
     * 弹栈
     */
    public void pop() {
        if (head == tail) {
            head = null;
            tail = null;
            min = null;
            return;
        }
        if (head == min) {
            min = head.nextMin;
        }
        head = head.nextNode;
    }

    /**
     * 获取栈顶元素
     *
     * @return 数据
     */
    public int top() {
        return head.data;
    }

    /**
     * 获取栈中最小元素
     *
     * @return 数据
     */
    public int getMin() {
        return min.data;
    }

    /**
     * 链表节点
     */
    private static class Node {
        /**
         * 数据
         */
        private final int data;

        /**
         * 下一个最小元素
         */
        private Node nextMin;

        /**
         * 下一个节点
         */
        private Node nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

}
