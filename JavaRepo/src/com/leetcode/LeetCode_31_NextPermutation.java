package com.leetcode;

import org.junit.Test;

import java.util.Arrays;


public class LeetCode_31_NextPermutation {
    public void nextPermutation(int[] nums) {

//        1. **从后向前**查找第一个**相邻升序**的元素对 `(i,j)`，满足 `A[i] < A[j]`。此时 `[j,end)` 必然是降序
//        2. 在 `[j,end)` **从后向前**查找第一个满足 `A[i] < A[k]` 的 `k`。`A[i]`、`A[k]` 分别就是上文所说的「小数」、「大数」
//        3. 将 `A[i]` 与 `A[k]` 交换
//        4. 可以断定这时 `[j,end)` 必然是降序，逆置 `[j,end)`，使其升序
//        5. 如果在步骤 1 找不到符合的相邻元素对，说明当前 `[begin,end)` 为一个降序顺序，则直接跳到步骤 4

        int len = nums.length;
        int i = len - 2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if (i >= 0){
            int j = len - 1;
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, len-1);
        System.out.println(Arrays.toString(nums));

    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }

    @Test
    public void test(){
        nextPermutation(new int[]{1, 5, 3, 8, 7, 2});
    }

}
