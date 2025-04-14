package com.example.myapplication.algorithm.dp;

public class code12 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int result = 1;
        for(int max : dp){
            result = Math.max(result,max);
        }
        return result;
    }
}
