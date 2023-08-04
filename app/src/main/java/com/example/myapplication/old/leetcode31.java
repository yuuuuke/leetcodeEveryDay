package com.example.myapplication.old;

import java.util.Arrays;

public class leetcode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int lastIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                lastIndex = i;
            }
        }
        if (lastIndex != -1) {
            int temp = nums[lastIndex];
            nums[lastIndex] = nums[lastIndex - 1];
            nums[lastIndex - 1] = temp;
        } else {
            Arrays.sort(nums);
        }
    }


}
