package com.example.myapplication.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;

public class leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, true);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums2) {
            if (map.get(num) != null) {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set) {
            result[index++] = i;
        }
        return result;
    }
}
