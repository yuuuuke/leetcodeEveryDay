package com.example.myapplication.algorithm.array;

public class leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 1;

        if (nums[0] > target) {
            return 1;
        } else {
            if (nums.length == 1) {
                return 0;
            }
        }

        int sum = nums[start] + nums[end];
        int result = 0;

        while (true) {
            if (sum < target) {
                //往后走
                end++;
                if (end >= nums.length) {
                    break;
                }
                sum = sum + nums[end];
            } else {
                if (result == 0) {
                    result = end - start + 1;
                } else {
                    result = Math.min(end - start + 1, result);
                }
                sum = sum - nums[start];
                //start 往前走
                start++;
                if (start == end) {
                    return 1;
                }
            }
        }
        return result;
    }
}
