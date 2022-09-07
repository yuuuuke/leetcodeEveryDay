package com.example.myapplication;

import java.util.HashMap;

public class leetcode167 {
//    public int[] twoSum(int[] numbers, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            map.put(numbers[i], i);
//            if (map.get(target - numbers[i]) != null) {
//                return new int[]{map.get(target - numbers[i]) +1, i+1};
//            }
//        }
//        return null;
//    }


    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return null;
    }
}
