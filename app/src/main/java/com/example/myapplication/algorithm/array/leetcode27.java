package com.example.myapplication.algorithm.array;

public class leetcode27 {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                while (nums[last] == val) {
                    last--;
                    count--;
                    if (last < 0) {
                        break;
                    }
                }
                if (i < last) {
                    nums[i] = nums[last];
                    nums[last] = val;
                    last--;
                    count--;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
