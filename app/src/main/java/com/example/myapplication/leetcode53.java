package com.example.myapplication;

public class leetcode53 {
    public int maxSubArray(int[] nums) {
        /*
         动态规划
         规定
         f(i) 是以  i下表结尾（理解一下什么是以i为下标结尾！） 的子串的最大和 （最大的和的子串也是以i结尾的！）   ，不要考虑子串的子串！！！！
         那么就有
         如果f(i) > 0
                f(i+1) = f(i) + A(n+1)
            f(i)<0
                f(i+1) = A(n+1)
         */
        if (nums.length == 1) {
            return nums[0];
        }

        int maxCurrent = nums[0];
        int maxFinal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxCurrent < 0) {
                maxCurrent = nums[i];
            } else {
                maxCurrent = maxCurrent + nums[i];
            }
            maxFinal = Math.max(maxFinal, maxCurrent);
        }
        return maxFinal;
    }
}
