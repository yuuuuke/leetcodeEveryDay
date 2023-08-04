package com.example.myapplication.old;

public class leetcode2501 {
    public int longestSquareStreak(int[] nums) {
        sort(0, nums.length - 1, nums);
        int index = 0;
        int last = 0;
        for (int num : nums) {
            if (index == 0) {
                last = num;
            }
            if (num == last * last) {
                index++;
            }
            last = num;
        }
        if (index == 1) {
            return -1;
        }
        return index;
    }

    private static void sort(int start, int end, int[] nums) {

        if(start >= end){
            return;
        }

        int center = nums[start];
        int low = start;
        int high = end;

        while (low < high) {
            while (nums[high] > center && high >= low) high--;
            nums[high] = nums[low];
            while (nums[low] < center && low <= high) low++;
            nums[low] = nums[high];
        }
        nums[low] = center;

        sort(start, low - 1, nums);
        sort(high + 1, end, nums);
    }
}
