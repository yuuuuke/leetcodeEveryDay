package com.example.myapplication.old;

public class leetcode55 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) {
                return false;
            }
            if (i + dp[i] >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
