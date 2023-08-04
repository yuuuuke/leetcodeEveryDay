package com.example.myapplication.old;

public class leetcode1750 {
    public int minimumLength(String s) {
        if(s.length() == 1){
            return 1;
        }
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        if (chars[start] != chars[end]) {
            return s.length();
        }
        char same = chars[0];
        while (true) {
            if(start > end){
                return 0;
            }
            if (chars[start] == same) {
                start++;
            }
            if (chars[end] == same) {
                end--;
            }
            if (start == end && chars[start] != same) {
                return 1;
            }
            if (chars[start] != same && chars[end] != same) {
                if (chars[start] == chars[end]) {
                    same = chars[start];
                } else {
                    return end - start + 1;
                }
            }
        }
    }
}
