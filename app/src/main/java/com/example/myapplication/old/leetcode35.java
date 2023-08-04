package com.example.myapplication.old;

public class leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return search(start, end, target, nums);
    }


    public static int search(int start, int end, int target, int[] nums) {
        if (end - start <= 1) {
            if (target > nums[end]) {
                return end + 1;
            } else if (target < nums[start]) {
                return start;
            } else {
                if(target == nums[end]){
                    return end;
                }else if(target == nums[start]){
                    return start;
                }else{
                    return end;
                }
            }
        }

        int center = start + (end - start) / 2;

        if (nums[center] > target) {
            return search(start, center, target, nums);
        } else {
            return search(center, end, target, nums);
        }
    }
}
