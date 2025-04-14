package com.example.myapplication.algorithm.dp;

public class code8 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[] firstRow = dp[0];
        int max = 0;
        for (int i = 0; i < firstRow.length; i++) {
            if (matrix[0][i] == '1') {
                firstRow[i] = 1;
                max = 1;
            } else {
                firstRow[i] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
