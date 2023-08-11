package com.example.myapplication.newstart.day7;

public class q1 {

    public int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }
        int length = grid.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < length; k++) {
                        if (k != j) {
                            min = Math.min(min, dp[i - 1][k]);
                        }
                    }
                    dp[i][j] = grid[i][j] + min;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            min = Math.min(dp[length-1][i],min);
        }
        return min;
    }
}
