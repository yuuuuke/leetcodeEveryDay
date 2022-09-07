package com.example.myapplication;

public class leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                result[index] = nums[start] * nums[start];
                start++;
            }else{
                result[index] = nums[end] * nums[end];
                end --;
            }
            index --;
        }
        return result;
    }
}
