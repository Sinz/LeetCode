package com.algorithm.sorting;


import org.junit.Test;

/*
 * @Author Zhao.J
 * @Date 17:03 2021/2/24
 * @Description 冒泡排序
 *  1. 比较相邻的元素，如果前一个比后一个元素大，则交换位置；
 *  2. 对每一对相邻元素，都坐同样的工作；
 */
public class D1_BubbleSort {
    int[] nums = {4,5,6,1,2,3};
    int num;
    @Test
    public void BubbleSort(){

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[i] > nums[i+1]){
                    num = nums[i];
                    nums[i+1] = nums[i];
                    nums[i] = num;
                }
            }
        }


    }

}
