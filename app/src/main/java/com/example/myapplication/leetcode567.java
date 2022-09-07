package com.example.myapplication;

import java.util.HashMap;

public class leetcode567 {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        int start = 0;
        int end = 0;
        char[] chars = s2.toCharArray();

        while (start < s2.length()) {
            if (map.get(chars[start]) != null) {
                //进入判断
                end = start;
                HashMap<Character, Integer> tempMap = (HashMap) map.clone();
                boolean tip = true;
                while (end < s2.length() && tip) {
                    System.out.print(chars[end]);
                    if (tempMap.get(chars[end]) == null) {
                        //寄了
                        tip = false;
                        if (map.get(chars[end]) == null) {
                            start = end + 1;
                        } else {
                            start++;
                        }
                    } else {
                        if (tempMap.get(chars[end]) > 1) {
                            tempMap.put(chars[end], tempMap.get(chars[end]) - 1);
                        } else {
                            tempMap.remove(chars[end]);
                        }
                    }
                    if (tempMap.size() == 0) {
                        return true;
                    }
                    end++;
                    if (end == s2.length()) {
                        return false;
                    }
                }
                System.out.println("");
            } else {
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }
}


