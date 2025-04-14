package com.example.myapplication.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class code6 {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        int last = nums[0];
        ArrayList<Integer> newNum = new ArrayList<>(100);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                last += nums[i];
                if (i == nums.length - 1) {
                    newNum.add(last);
                }
            } else {
                newNum.add(last);
                last = nums[i];
                if (nums[i] - 1 != nums[i - 1]) {
                    newNum.add(0);
                }
                if (i == nums.length - 1) {
                    newNum.add(last);
                }
            }
        }
        int[] dp = new int[newNum.size()];
        dp[0] = newNum.get(0);
        dp[1] = Math.max(newNum.get(1), newNum.get(0));
        System.out.println(newNum.toString());
        for (int j = 2; j < dp.length ; j++) {
            dp[j] = Math.max(dp[j-1],dp[j-2]+ newNum.get(j));
        }
        return dp[dp.length-1];
    }
}
