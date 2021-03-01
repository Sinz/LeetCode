package com.leetcode;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划
// 👍 2048 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_42_TrappingRainWater {
    public int trap(int[] height) {

        int result = 0;

        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int curIndex = 0;

        while(curIndex < n){
            while(!stack.isEmpty() && height[curIndex]>height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }

                int distance = curIndex - stack.peek() - 1; //两堵墙之前的距离。
                int h = Math.min(height[stack.peek()], height[curIndex]) - height[top];
                result = result + distance * h;
            }
            stack.push(curIndex++); //当前指向的墙入栈
        }

        return result;
    }

    public int trapp(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax){
                water += leftMax - height[left];
                left++;
            }else{
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
