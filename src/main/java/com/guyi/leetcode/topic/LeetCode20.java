package com.guyi.leetcode.topic;

import java.util.*;

/**
 * 题目: 有效括号
 * 原题链接: https://leetcode.cn/problems/valid-parentheses
 * <p>
 * 题目描述:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * - 左括号必须用相同类型的右括号闭合。
 * - 左括号必须以正确的顺序闭合。
 * - 每个右括号都有一个对应的相同类型的左括号。
 *
 * @author 孤诣
 */
public class LeetCode20 {

    public static void main(String[] args) {
        // true
        System.out.println(isValid("()"));

        // true
        System.out.println(isValid("()[]{}"));

        // false
        System.out.println(isValid("(]"));

        // false
        System.out.println(isValid("})"));
    }

    /**
     * 执行时间: 51.62%  内存占用 8.24%
     */
    public static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        final Map<Byte, Byte> parenthesisMapping = new HashMap<>(3);
        parenthesisMapping.put(")".getBytes()[0], "(".getBytes()[0]);
        parenthesisMapping.put("}".getBytes()[0], "{".getBytes()[0]);
        parenthesisMapping.put("]".getBytes()[0], "[".getBytes()[0]);

        byte[] items = s.getBytes();

        Stack<Byte> stack = new Stack<>();
        for (byte item : items) {
            if (parenthesisMapping.containsKey(item)) {
                // 匹配到右括号
                if (stack.size() > 0 && stack.peek().equals(parenthesisMapping.get(item))) {
                    // 栈顶元素是和当前右括号匹配的左括号
                    stack.pop();
                    continue;
                }

                // 栈顶元素不是和当前右括号匹配的左括号
                return false;
            }

            stack.push(item);
        }

        return stack.size() == 0;
    }

}
