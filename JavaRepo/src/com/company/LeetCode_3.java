package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个字符串，请你找出其中不含有重复字符的?最长子串?的长度。

示例?1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
Related Topics
哈希表
双指针
字符串
Sliding Window
\n
👍 4161
👎 0*/
public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        Map map = new HashMap<Character,Integer>();

        for (int i = 0; i < len; i++) {

            char chr = s.charAt(i);
            if (!map.containsKey(chr)) {
                map.put(i, s.substring(i, 1));
            }
        }

        return map.size();

    }

    @Test
    public void test(){
        int size = lengthOfLongestSubstring("String");
        System.out.println(size);
    }
}
