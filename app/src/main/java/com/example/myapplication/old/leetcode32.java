package com.example.myapplication.old;

import java.util.Stack;

public class leetcode32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        char[] content = s.toCharArray();
        for (int i = 1; i < content.length; i++) {
            if (content[i] == '(') {
                // 左括号并不能与前面任何一位匹配
                dp[i] = 0;
            } else {
                if (content[i - 1] == '(') {
                    // content[i] 和 content[i-1] 匹配
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    // content[i-1] 是 )  那么就要考虑  (((()))) 这种情况，思考 content[i]的这个 ) 是要和哪个位置进行匹配
                    if (i - dp[i - 1] - 1 >= 0) {
                        if (content[i - dp[i - 1] - 1] == '(') {
                            if(i - dp[i - 1] - 1 == 0){
                                dp[i] = dp[i - 1] + 2;
                            }else{
                                dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                            }
                        } else {
                            dp[i] = 0;
                        }
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
