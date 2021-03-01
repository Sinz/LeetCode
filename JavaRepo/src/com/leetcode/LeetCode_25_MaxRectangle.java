package com.leetcode;

public class LeetCode_25_MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 1){
                dp[i][0] = matrix[i-1][0]+1;
            }else{
                dp[i][0] = 0;
            }
        }
        for (int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 1){
                dp[0][j] = matrix[0][j-1]+1;
            }else{
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }else if(matrix[i][j-1] == 0 && matrix[i-1][j] == 1 && matrix[i][j] == 1){
                    // 1. 左侧为0，上方为1；
                    dp[i][j] = dp[i-1][j] + 1;
                }else if(matrix[i][j-1] == 1 && matrix[i-1][j] == 0 && matrix[i][j] == 1){
                    // 2. 左侧为1，上方为0；
                    dp[i][j] = dp[i][j-1] + 1;
                }else if(matrix[i][j-1] == 1 && matrix[i-1][j ]== 1 && matrix[i][j] == 1){
                    // 3. 左侧为1，上方为1；
                    dp[i][j] = Math.max (Math.min(dp[i][j-1], dp[i-1][j])*2,Math.max(dp[i][j-1], dp[i-1][j])+1);
                }else if(matrix[i][j-1] == 0 && matrix[i-1][j] == 0 && matrix[i][j] == 1) {
                    // 4. 左侧为0，上方为0；
                    dp[i][j] = 1;
                }

                max = Math.max(dp[i][j] , max);
            }
        }
        return max;

    }
}
