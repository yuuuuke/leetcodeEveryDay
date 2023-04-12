package com.example.myapplication.algorithm.hash;

import java.util.HashMap;

public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : chars) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int i : ransomNote.toCharArray()) {
            if (map.get(i) == null || map.get(i) == 0) {
                return false;
            } else {
                map.put(i, map.get(i) - 1);
            }
        }
        return true;
    }
}
