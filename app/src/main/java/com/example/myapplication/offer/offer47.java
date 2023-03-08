package com.example.myapplication.offer;

public class offer47 {
    int result = 0;

    public int maxValue(int[][] grid) {
        //暴力遍历
//        go(0, 0, 0, grid);

        // 动态规划
        int[][] max = new int[grid.length][grid[0].length];

        max[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            max[i][0] = max[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            max[0][j] = max[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + grid[i][j];
            }
        }

        return max[grid.length - 1][grid[0].length - 1];

//        return result;
    }

    public void go(int current, int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length) {
            return;
        }
        current = current + grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            result = Math.max(result, current);
            return;
        }
        go(current, i + 1, j, grid);
        go(current, i, j + 1, grid);
    }
}
