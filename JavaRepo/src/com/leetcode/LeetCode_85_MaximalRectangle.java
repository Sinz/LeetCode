package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                if ( matrix[i][j] == 1 ){
                    heights[j] ++;
                }else {
                    heights[j] = 0;
                }

            }
            maxArea = Math.max(maxArea, max(heights));

        }

        return maxArea;
    }

    private int max(int[] nums){
        int n = nums.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            while(stack.peek() != -1 && stack.peek() >= nums[i]){
                max = Math.max(max, nums[stack.pop()]*(i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while(stack.pop() != -1){
            max = Math.max(max, nums[stack.pop()]*(n - stack.peek() - 1));
        }

        return max;
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        stack.push(-1);
        // 1. 建立单调栈
        for (int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                // 当元素pop时， 记录maxArea
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() -1));
            }
            stack.push(i);
        }

        // 2. 计算栈内每个元素构成的矩形面积

        while(stack.peek() != -1){
            maxArea = Math.max(maxArea,  heights[stack.pop()] * (n - stack.peek() -1));
        }

        return maxArea;
    }
}
