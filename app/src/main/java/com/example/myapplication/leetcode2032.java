package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            if (map.get(i) != null) {
                if (map.get(i) == -1) {
                    continue;
                }
                if (map.get(i) == 1) {
                    list.add(i);
                    map.put(i, -1);
                }
            } else {
                map.put(i, 2);
            }
        }
        for (int i : nums3) {
            if (map.get(i) != null && map.get(i) != -1) {
                list.add(i);
                map.put(i,-1);
            }
        }
        return list;
    }
}
