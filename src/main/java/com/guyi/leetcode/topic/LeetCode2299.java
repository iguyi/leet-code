package com.guyi.leetcode.topic;

/**
 * 题目: 强密码检验器 ii
 * 原题链接: https://leetcode.cn/problems/strong-password-checker-ii/description/
 * <p>
 * 题目描述:
 * 如果一个密码满足以下所有条件, 我们称它是一个 强密码:
 * - 它有至少 8个字符。
 * - 至少包含一个小写英文字母。
 * - 至少包含一个大写英文字母。
 * - 至少包含一个数字。
 * - 至少包含一个特殊字符。特殊字符为: "!@#$%^&*()-+" 中的一个。
 * - 它不包含 2 个连续相同的字符（比方说 "aab" 不符合该条件, 但是"aba"符合该条件）。
 * 给你一个字符串password, 如果它是一个强密码, 返回true, 否则返回 false。
 *
 * @author 孤诣
 */
public class LeetCode2299 {

    public static void main(String[] args) {
        String password = "yvTY#@IB#*!hjrQt-TLW&z)$@!%Duqt&ToskxHgnybqpndMI+wP&fcemIk#@KnkMTaUkcIbncpTL";
        System.out.println(attempt1(password));
    }

    /**
     * 执行用时: 19 ms - 6.73%
     * 内存占用: 41.60 MB - 5.77%
     */
    public static boolean attempt1(String password) {
        return (password.length() >= 8)  // 长度
                && password.matches(".*[a-z]+.*")  // 至少一个小写字母
                && password.matches(".*[A-Z]+.*")  // 至少一个大写字母
                && password.matches(".*[0-9]+.*")  // 至少一个数字
                && password.matches(".*[!@#$%^&*()\\-+]+.*")  // 至少一个特殊字符
                && !password.matches(".*([a-zA-Z0-9!@#$%^&*()\\-+])\\1.*");  // 不含重复字符
    }

}
