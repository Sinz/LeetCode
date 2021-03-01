package com.leetcode;
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 1417 👎 0
public class LeetCode_72_EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        // 1. 定义状态
        int [][] dp = new int[len1][len2];
        // 2. 状态初始化
        for (int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2; j++) {
            dp[0][j] = j;
        }
        // 3. 推导状态方程
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(array1[i-1] == array2[j-1]){
                    // 最后一个字符相等
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }else {
                    // 最后一个字符不等，修，删，增
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]),dp[i-1][j]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
