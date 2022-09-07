package com.example.myapplication;

import android.util.Log;

public class leetcode704 {
    public static int search(int[] nums, int target) {
        return search(0, nums.length - 1, target, nums);
    }

    public static int search(int start, int end, int target, int[] nums) {
        System.out.println("start" + start + "end" + end);
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        int center = (end + start) / 2;
        if (nums[center] == target) {
            return center;
        } else if (nums[center] > target) {
            return search(start, center, target, nums);
        } else {
            return search(center, end, target, nums);
        }
    }

    public static void main(String[] args) {
        search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }
}
