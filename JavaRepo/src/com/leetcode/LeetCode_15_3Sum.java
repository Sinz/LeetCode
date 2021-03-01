package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_3Sum {
    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 2949 👎 0


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;

        if (nums.equals("") || len < 3){
            return result;
        }

        for (int i = 0; i < len-1; i++) {
            int L = i+1;
            int R = len-1;
            if (nums[i] > 0) {
                break;
            }
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }

            while( L < R ){

                while(nums[L] == nums[L+1] && L < R){
                    L ++ ;
                }
                while(nums[R] == nums[R-1] && L < R){
                    R--;
                }

                if (nums[i] + nums[L] + nums[R] < 0){
                    L++;
                }else if(nums[i] + nums[L] + nums[R] > 0){
                    R--;
                }else if(nums[i] + nums[L] + nums[R] == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    L++;
                }
            }

        }

        return result ;
    }



}
