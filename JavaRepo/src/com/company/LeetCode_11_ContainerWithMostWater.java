package com.company;

import java.util.Arrays;

public class LeetCode_11_ContainerWithMostWater {
    public int maxArea(int[] height) {

        int len = height.length;

        int area = 0;
        int left = 1;
        int right = len;

        while (left < right) {
            area = Integer.max(area, Integer.min(height[left-1],height[right-1]) * (right - left));
            if (height[left-1] <= height[right-1]){
                left ++;
            }else if(height[left-1] > height[right-1]){
                right --;
            }
        }

        return area;
    }
}
