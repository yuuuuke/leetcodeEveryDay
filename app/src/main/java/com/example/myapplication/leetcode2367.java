package com.example.myapplication;

public class leetcode2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int length = nums[nums.length - 1] + 1;
        int[] temp = new int[length];
        for (int i : nums) {
            temp[i] = 1;
        }
        int result = 0;
        for (int j : nums) {
            if (j + diff < temp.length - 1 && j + 2 * diff < temp.length - 1) {
                if (temp[j + diff] != 0 && temp[j + 2 * diff] != 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
