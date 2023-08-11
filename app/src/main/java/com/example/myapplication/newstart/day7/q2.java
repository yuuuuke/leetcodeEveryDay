package com.example.myapplication.newstart.day7;

/**
 * https://leetcode.cn/problems/matrix-diagonal-sum/
 */
public class q2 {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i] + mat[mat.length - 1 - i][i];
        }
        if (mat.length % 2 == 1) {
            // 奇数
            sum = sum - mat[mat.length / 2 ][mat.length / 2 ];
        }
        return sum;
    }
}
