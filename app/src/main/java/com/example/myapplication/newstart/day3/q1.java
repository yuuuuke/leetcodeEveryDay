package com.example.myapplication.newstart.day3;

import static com.example.myapplication.Utils.LogIntArray;

public class q1 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 从后往前
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = getRegin(i, nums, dp);
        }
        return dp[0];
    }

    public int getRegin(int index, int[] nums, int[] dp) {
        if (nums[index] >= nums.length - 1 - index) {
            // 可以一步跳到终点
            return 1;
        } else {
            // 不能一步跳到终点，那么就从它可以跳到地方，找最小的那个，然后+1
            int min = dp[index + 1];
            for (int i = index + 2; i <= index + nums[index]; i++) {
                min = Math.min(min, dp[i]);
            }
            return min + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 0, 1};
        new q1().jump(nums);
    }
}
