package com.guyi.leetcode.topic;

import com.guyi.leetcode.common.ListNode;

/**
 * 题目: 两数相加
 * 原题链接: https://leetcode.cn/problems/add-two-numbers/
 * <p>
 * 题目描述:
 * 你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例:
 * l1：2->4->3
 * l2：5->6->4
 * return  342+465 = 807
 *
 * @author 孤诣
 */
public class LeetCode2 {

    /**
     * 执行用时: 100.0%  内存占用: 47.54%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1、l2 节点数量的最大值
        int maxNodeNum = 99;

        // 分别用来存储 l1、l2 的内容
        int[] number1 = new int[100];
        int[] number2 = new int[100];

        // 进位
        int cache = 0;

        // 统计 l1 节点数
        ListNode temp = l1;
        int index = maxNodeNum;
        while (temp != null) {
            number1[index--] = temp.val;
            temp = temp.next;
        }
        int number1Size = maxNodeNum - index;

        // 统计 l1 节点数
        temp = l2;
        index = maxNodeNum;
        while (temp != null) {
            number2[index--] = temp.val;
            temp = temp.next;
        }
        int number2Size = maxNodeNum - index;

        // 计算返回链表最多会有多少个节点
        final int numberSize = Math.max(number1Size, number2Size);
        final int resultSize = numberSize + 1;

        // 存储返回链表中, 各个节点的值
        int[] result = new int[resultSize];

        int tempIndex = 0;
        // 临时记录运算结果
        int tempResult;

        // 计算两数和: 个位 -> 末位
        for (int i = maxNodeNum; i >= maxNodeNum - numberSize; i--) {
            tempResult = number1[i] + number2[i] + cache;
            if (tempResult >= 10) {
                // 大于 10, 需要进位
                tempResult = tempResult - 10;
                result[tempIndex++] = tempResult;
                cache = 1;
                continue;
            }

            result[tempIndex++] = tempResult;
            if (i == maxNodeNum - numberSize) {
                break;
            }

            // 走到这里, 说明当前位数的数字相加, 不大于10, 不需要进位
            cache = 0;
        }

        // 表示最终结果是否是 resultSize 位数, 默认不是
        boolean flag = false;
        if (cache == 1) {
            // 将进位数字(1)存入在返回结果的最高位对应的节点将进位存
            result[resultSize - 1] = 1;
        } else {
            flag = true;
        }

        // 最终的返回结果
        ListNode resultHead = new ListNode();

        // 将 result 数组中的内容逐个存入 resultHead 中
        ListNode currentNode = resultHead;
        ListNode currentNodeFront = null;
        for (int i = 0; i < result.length; i++) {
            if (flag && i == result.length - 1) {
                // 数据装填结束, result 数组中最后一个元素是无效数字
                break;
            }

            currentNode.val = result[i];
            currentNode.next = new ListNode();
            currentNodeFront = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNodeFront != null) {
            currentNodeFront.next = null;
        }
        return resultHead;
    }

}
