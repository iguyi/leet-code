package com.guyi.leetcode.topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目: 随机链表的复制
 * 原题链接: http://t.csdnimg.cn/7oSN6
 * <p>
 * 题目描述:
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 题解: https://blog.csdn.net/iguyi/article/details/134127969
 *
 * @author 孤诣
 */
public class LeetCode138 {
    public static void main(String[] args) {
    }

    /**
     * 方式一：本质是哈希表
     * 执行时间:5.4%  内存占用 88.69%
     */
    public Node copyRandomList(Node head) {
        Node currentNode = head;
        List<Node> nodeList = new ArrayList<>();
        List<Node> newNodeList = new ArrayList<>();
        while (currentNode != null) {
            nodeList.add(currentNode);
            newNodeList.add(new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        // random 有可能指向 null，所以应当认为链表以 null 节点为结尾
        nodeList.add(null);
        newNodeList.add(null);
        int length = nodeList.size();
        int randomIndex;
        for (int i = 0; i < length - 1; i++) {
            newNodeList.get(i).next = newNodeList.get(i + 1);
            randomIndex = nodeList.indexOf(nodeList.get(i).random);
            newNodeList.get(i).random = newNodeList.get(randomIndex);
        }
        return newNodeList.get(0);
    }

    /**
     * 方式二: 将方式一简化为哈希表方式
     * 执行时间: 5.4%  内存占用: 27.26%
     */
    public Node copyRandomList2(Node head) {
        Node currentNode = head;
        Map<Node, Node> map = new HashMap<>();
        while (currentNode != null) {
            map.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        map.forEach((k, v) -> {
            v.next = map.get(k.next);
            v.random = map.get(k.random);
        });
        return map.get(head);
    }

    /**
     * 方式三: 还是哈希表, 遍历传递 random 的值时, 采用 while 循环而不是调用 Map 提供 forEach(), 效率更高（可以看它的源码验证）。
     * 执行时间: 100%  内存占用: 98.73%
     */
    public Node copyRandomList3(Node head) {
        Node currentNode = head;
        Map<Node, Node> map = new HashMap<>();
        while (currentNode != null) {
            map.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        currentNode = head;
        while (currentNode != null) {
            map.get(currentNode).next = map.get(currentNode.next);
            map.get(currentNode).random = map.get(currentNode.random);
            currentNode = currentNode.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
