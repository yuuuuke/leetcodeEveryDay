package com.example.myapplication.newstart.day8;

/**
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 *
 * WRONG . 用排序来写把
 */
public class q1 {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;
        if (nums.length == 1) {
            return 0;
        }
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < last) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < i) {
                        start = j + 1;
                        break;
                    } else {
                        if (j == 0) {
                            start = 0;
                        }
                    }
                }
                break;
            }
        }

        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] > last) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < i) {
                        end = j - 1;
                        break;
                    }else {
                        if (j == nums.length-1) {
                            end = nums.length;
                        }
                    }
                }
                break;
            }
        }
        return end - start;
    }
}
