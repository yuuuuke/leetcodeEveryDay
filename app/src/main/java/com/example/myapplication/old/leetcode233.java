package com.example.myapplication.old;

public class leetcode233 {
    public int countDigitOne(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n == 0) {
            return 0;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num = 0;
            for (char c : String.valueOf(n).toCharArray()) {
                if (c == '1') num++;
            }
            dp[i] = num + dp[i - 1];
        }
        return dp[n];
    }
}
