package com.leetcode;

/*
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

        '.' 匹配任意单个字符
        '*' 匹配零个或多个前面的那一个元素
        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。


        示例 1：

        输入：s = "aa" p = "a"
        输出：false
        解释："a" 无法匹配 "aa" 整个字符串。
        示例 2:

        输入：s = "aa" p = "a*"
        输出：true
        解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
        示例 3：

        输入：s = "ab" p = ".*"
        输出：true
        解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
        示例 4：

        输入：s = "aab" p = "c*a*b"
        输出：true
        解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
        示例 5：

        输入：s = "mississippi" p = "mis*is*p*."
        输出：false


        提示：

        0 <= s.length <= 20
        0 <= p.length <= 30
        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
        保证每次出现字符 * 时，前面都匹配到有效的字符
        Related Topics
        字符串
        动态规划
        回溯算法
        \n
        👍 1839
        👎 0

*/
public class LeetCode_10_RegularExpressingMatching {

    public boolean isMatch_DFS(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firsMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch_DFS(s, p.substring(2)) || (firsMatch && isMatch_DFS(s.substring(1), p));
        }else {
            return firsMatch && isMatch_DFS(s.substring(1),p.substring(1));
        }
    }

    public boolean isMatch_DP(String s, String p) {
        int m = s.length(), n = p.length();
        boolean [][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i= 2; i <= n; i++){
            if (p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i=1; i<=m; i++){
            for (int j = 1; j <=n ; j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);

                if(sc == pc || pc == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (pc == '*'){
                    if(dp[i][j-2]){
                        dp[i][j] = true;
                    }else if (sc == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i-1][j];
                    }
                }

            }
        }

        return dp[m][n];
    }
}
