package com.example.myapplication.algorithm.dp;

/**
 * https://leetcode.cn/problems/longest-palindromic-subsequence/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class code11 {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 1;
            }
        }
        for (int i = 2; i < chars.length; i++) {
            for (int j = 0; j + i < chars.length; j++) {
                if (chars[j] == chars[j + i]) {
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                } else {
                    dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][i + j]);
                }
                System.out.println(i+"//"+j+"//"+dp[j][i+j]);
            }
        }
        return dp[0][s.length()-1];
    }
}
