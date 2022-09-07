package com.example.myapplication;

import java.util.HashSet;
import java.util.Objects;

public class leetcode695 {

    int max = 0;
    int temp = 0;
    private int length;
    private int height;

    public int maxAreaOfIsland(int[][] grid) {
        height = grid.length;
        length = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //开始搜索
                    temp = 0;
                    isOne(grid, i, j);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    private void isOne(int[][] grid, int sr, int sc) {
        if (grid[sr][sc] == 1) {
            grid[sr][sc] = 0;
            temp++;
            if (sr - 1 >= 0) {
                isOne(grid, sr - 1, sc);
            }
            if (sr + 1 <= height - 1) {
                isOne(grid, sr + 1, sc);
            }
            if (sc + 1 <= length - 1) {
                isOne(grid, sr, sc + 1);
            }
            if (sc - 1 >= 0) {
                isOne(grid, sr, sc);
            }
        }
    }
}
