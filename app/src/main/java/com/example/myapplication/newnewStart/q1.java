package com.example.myapplication.newnewStart;

import java.util.Arrays;

/**
 * "<a href="https://leetcode.cn/problems/next-permutation/description/">...</a>"
 */
public class q1 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (max > nums[i]) {
                // i 要跟最前面大于nums[i]的换位置
                for (int j = nums.length - 1; j > i; j--) {
                    if(nums[j] > nums[i]){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        // 然后从 i+1 到 length-1 要重排序
                        if(i+1 < nums.length-1){
                            Arrays.sort(nums,i+1,nums.length);
                        }
                        return;
                    }
                }
            } else {
                max = nums[i];
            }
        }
        Arrays.sort(nums);
    }
}
