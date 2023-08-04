package com.example.myapplication.old;

public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int temp = -1;
        while (start < end) {
            int index = (start + end) / 2;
            if (nums[index] > target) {
                end = index;
            } else if (nums[index] < target) {
                start = index;
            } else {
                temp = index;
                break;
            }
        }
        if (temp == -1) {
            return new int[]{-1, -1};
        }
        start = end = temp;
        while (nums[start] == target) {
            start--;
            if (start < 0 || nums[start] != target) {
                start++;
                break;
            }
        }
        while (nums[end] == target) {
            end++;
            if (end >= nums.length || nums[end] != target) {
                end--;
                break;
            }
        }
        return new int[]{start, end};
    }
}
