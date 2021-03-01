package com.leetcode;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1138 👎 0

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(res, list, nums);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums){

        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(res, list, nums);
            // 当生成list 后, 保留首位, 继续排列
            list.remove(list.size() - 1);
        }
    }

}
