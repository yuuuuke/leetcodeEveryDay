package com.example.myapplication.algorithm.String;

import java.util.HashMap;

public class leetcode4 {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : sChar) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char c : tChar) {
            if (map.get(c) == null) {
                return false;
            } else {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        return map.size() == 0;
    }
}
