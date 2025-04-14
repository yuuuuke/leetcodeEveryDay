package com.example.myapplication.algorithm.dp;

import java.util.Arrays;

public class code10 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        dp[questions.length - 1] = questions[questions.length - 1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            int[] question = questions[i];
            int next = question[1] + 1 + i;
            if (next >= questions.length) {
                dp[i] = Math.max(question[0], dp[i + 1]);
            } else {
                dp[i] = Math.max(question[0] + dp[next], dp[i + 1]);
            }
        }
        return dp[0];
    }
}
