package com.example.myapplication.algorithm.hash;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int num = n1 + n2;
                if (map1.get(num) == null) {
                    map1.put(num, 1);
                } else {
                    map1.put(num, map1.get(num) + 1);
                }
            }
        }

        for (int n1 : nums3) {
            for (int n2 : nums4) {
                int num = n1 + n2;
                if (map2.get(num) == null) {
                    map2.put(num, 1);
                } else {
                    map2.put(num, map2.get(num) + 1);
                }
            }
        }
        int result = 0;
        for (int num : map1.keySet()) {
            if (map2.get(-num) != null) {
                result = result + map1.get(num) * map2.get(-num);
            }
        }
        return result;
    }
}
