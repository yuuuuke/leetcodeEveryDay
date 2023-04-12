package com.example.myapplication.algorithm.array;

public class leetcode59 {
    public int[][] generateMatrix(int n) {
        int x = 0;
        int y = 0;
        int count = 1;
        int[][] result = new int[n][n];
        result[0][0] = 1;
        if(n == 1){
            return result;
        }
        count ++;
        while (true) {
            if (result[x][y + 1] != 0) {
                return result;
            }
            y++;
            while (y <= n - 1 && y >= 0 && result[x][y] == 0) {
                result[x][y] = count;
                count++;
                y++;
            }
            y--;
            if (result[x + 1][y] != 0) {
                return result;
            }
            x++;
            while (x <= n - 1 && x >= 0 && result[x][y] == 0) {
                result[x][y] = count;
                count++;
                x++;
            }
            x--;
            if (result[x][y - 1] != 0) {
                return result;
            }
            y--;
            while (y <= n - 1 && y >= 0 && result[x][y] == 0) {
                result[x][y] = count;
                count++;
                y--;
            }
            y++;
            if (result[x - 1][y] != 0) {
                return result;
            }
            x--;
            while (x <= n - 1 && x >= 0 && result[x][y] == 0) {
                result[x][y] = count;
                count++;
                x--;
            }
            x++;
        }
    }
}
