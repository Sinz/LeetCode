package com.leetcode;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 794 👎 0

import java.util.HashMap;
import java.util.Map;


public class LeetCode_79_WordCount {
    public boolean exist(char[][] board, String word) {

        int index = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,  chars,  i, j,  index)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int index){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index] ){
            return false;
        }

        if(index == word.length-1){
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = '.';
        boolean res = dfs( board,  word,  i+1, j,  index+1) ||
                dfs( board,  word,  i-1, j,  index+1) ||
                dfs( board,  word,  i, j+1,  index+1) ||
                dfs( board,  word,  i, j-1,  index+1);
        board[i][j] = tmp;

        return res;
    }
}
