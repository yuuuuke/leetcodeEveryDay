package com.example.myapplication.old;

public class leetcode189 {
    public void rotate(int[] nums, int k) {
        if(nums.length ==1){
            return;
        }
        int[] result = nums.clone();
        for (int i = 0; i < result.length; i++) {
            if (i - k < 0) {
                nums[i] = result[i - k + result.length];
            }else{
                nums[i] = result[i - k];
            }
        }
    }
}
