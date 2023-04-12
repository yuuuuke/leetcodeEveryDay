package com.example.myapplication;

public class leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = -1;
        int min = -1;

        int tempMin = -1;

        int start = -1;
        int end = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] >= nums[i - 1]) {
                //正常,next
                if (max != -1) {
                    if (nums[i - 1] > min && nums[i - 1] <= max) {
                        start = i - 1;
                    }
                }
            } else {
                //异常,换位置
                start = i - 1;
                end = i;
                if (max == -1) {
                    max = nums[i - 1];
                    min = nums[i];
                }
            }
        }
    }
}
