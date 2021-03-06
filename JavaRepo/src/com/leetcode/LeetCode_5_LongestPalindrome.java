package com.leetcode;
/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
Related Topics
字符串
动态规划
*/


public class LeetCode_5_LongestPalindrome {
    public String longestPalindrome(String s) {
        int start = 0;
        int lenth = 0;
        for (int cur = 0; cur < s.length(); cur++) {
            int maxLen = Math.max(getlen(s, cur, cur), getlen(s, cur, cur + 1));
            if (maxLen > lenth) {
                lenth = maxLen;
                start = cur - (lenth - 1) / 2;
            }
        }

        return  s.substring(start , start+lenth);

    }

    public int getlen(String s,int l , int r){
        while (l > 0 && r < s.length() &&  s.charAt(l) == s.charAt(r) ){
            --l;
            ++r;
        }
        return l - r -1 ;
    }
}
