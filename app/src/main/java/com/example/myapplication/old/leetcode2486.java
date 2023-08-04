package com.example.myapplication.old;

public class leetcode2486 {
    public int appendCharacters(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int index = 0;
        for (char c : sChars) {
            if (c == tChars[index]) {
                index++;
            }
            if (index >= tChars.length) {
                return 0;
            }
        }
        return tChars.length - index;
    }
}
