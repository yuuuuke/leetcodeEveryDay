package com.example.myapplication.algorithm.array;

public class leetcode2 {
    public void moveZeroes(int[] nums) {
        int temp = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //开始冒泡
                start = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        temp = nums[j];
                        nums[j] = nums[start];
                        nums[start] = temp;
                        start = j;
                    }
                }
            }
        }
    }
}
