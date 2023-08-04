package com.example.myapplication.old;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            //全是正数或者全是复数
            return list;
        }
        int i, j;
        int sum;
        for (int k = 0; k < nums.length; k++) {
            if (k > 0 &&nums[k] == nums[k - 1]) {
                continue;
            }
            i = k + 1;
            j = nums.length - 1;
            while (i < j) {
                sum = nums[i] + nums[j];
                if (sum == -nums[k]) {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(0, nums[i]);
                    result.add(1, nums[k]);
                    result.add(2, nums[j]);
                    list.add(result);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    j--;
                    i++;
                } else if (sum > -nums[k]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
