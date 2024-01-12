package com.guyi.leetcode.topic;

/**
 * 题目: 文件夹操作日志搜集器
 * 原题链接: https://leetcode.cn/problems/crawler-log-folder/description/
 * <p>
 * 题目描述:
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * 下面给出对变更操作的说明：
 * - "../" : 移动到当前文件夹的父文件夹。如果已经在主文件夹下, 则 继续停留在当前文件夹。
 * - "./" : 继续停留在当前文件夹。
 * - "x/" : 移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 i^th 步执行的操作。
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 *
 * @author 孤诣
 */
public class LeetCode1598 {

    public static void main(String[] args) {
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(logs1) == 2);

        String[] logs2 = {"../", "d1/", "../", "d21/", "../"};
        System.out.println(minOperations(logs2) == 0);

        String[] logs3 = {"./", "../", "./"};
        System.out.println(minOperations(logs3) == 0);

        String[] logs4 = {"../", "../", "../"};
        System.out.println(minOperations(logs4) == 0);
    }

    /**
     * 执行用时: 1 ms - 97.42%
     * 内存占用: 39.48 MB - 100%
     */
    public static int minOperations(String[] logs) {
        // 步数
        int stepNumber = 0;

        // 开始遍历
        for (String log : logs) {
            // 判断是否是 "../"
            if ("../".equals(log)) {
                // 根据当前步数的执行来决定不是是否发送变化
                if (stepNumber > 0) {
                    --stepNumber;
                }
                // 跳出当前循环
                continue;
            }

           /*
              程序能执行到此，说明当前操作一定不会是 "../",
              而 "./" 操作不影响步数, 所以只需要验证当前操作不为 "./" 即可,
              只要条件成立, 当前步数+1即可
            */
            if (!"./".equals(log)) {
                stepNumber++;
            }
        }
        return stepNumber;
    }

}
