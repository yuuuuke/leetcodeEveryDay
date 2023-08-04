package com.example.myapplication.old;

public class leetcode75 {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i > start + 1) {
                    //需要交换
                }
            } else if (nums[i] == 2) {
                if (i < end - 1) {
                    //需要交换
                }
            }
        }
    }
}
