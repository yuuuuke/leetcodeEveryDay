package com.example.myapplication.algorithm.dp;

public class code9 {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            left = right = i;
        }
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                dp[i - 1][i] = true;
                right = i;
                left = i - 1;
            }
        }
        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; j + i < s.length(); i++) {
                if (dp[i + 1][i + j - 1]) {
                    if (chars[i] == chars[i + j]) {
                        dp[i][i + j] = true;
                        if (j > right - left) {
                            right = i+j;
                            left = i;
                        }
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }
}
