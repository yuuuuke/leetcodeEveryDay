package com.example.myapplication.newnewStart;

public class q12 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? -1 : 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = -1;
                } else {
                    if (i == 0) {
                        if (dp[i][j - 1] != -1) {
                            dp[i][j] = dp[i][j - 1];
                        } else {
                            dp[i][j] = -1;
                        }
                    } else if (j == 0) {
                        if (dp[i - 1][j] != -1) {
                            dp[i][j] = dp[i - 1][j];
                        } else {
                            dp[i][j] = -1;
                        }
                    } else {
                        if (dp[i][j - 1] == -1 && dp[i - 1][j] == -1) {
                            dp[i][j] = -1;
                        } else if (dp[i][j - 1] == -1) {
                            dp[i][j] = dp[i - 1][j];
                        } else if (dp[i - 1][j] == -1) {
                            dp[i][j] = dp[i][j - 1];
                        } else {
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    }
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == -1 ? 0 : dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
