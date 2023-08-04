package com.example.myapplication.old;

public class leetcode91 {
    /**
     * 动态规划
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0' && chars[i - 1] == '0') {
                //非法字段
                return 0;
            }
            int result = 0;
            if (chars[i] != 0) {
                result += dp[i - 1];
            }
            if (isLegal(chars[i - 1], chars[i])) {
                if (i - 2 >= 0) {
                    result += dp[i - 2];
                } else {
                    result += 1;
                }
            }
            dp[i] = result;
        }
        return dp[s.length()-1];
    }

    public boolean isLegal(char c1, char c2) {
        int temp1 = c1 - '0';
        int temp2 = c2 - '0';
        int result = temp1 * 10 + temp2;
        return result >= 10 && result <= 26;
    }
}
