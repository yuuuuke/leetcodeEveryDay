package com.example.myapplication;

import java.util.Arrays;

public class leetcode2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum <= queries[i]) {
                    result[i] = j + 1;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}

