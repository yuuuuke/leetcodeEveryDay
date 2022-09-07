package com.example.myapplication;

public class leetcode647 {
    public static int countSubstrings(String s) {
        int count = s.length();
        int start, end;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            start = i - 1;
            end = i + 1;
            while (start >= 0 && end <= chars.length - 1) {
                if (chars[start] == chars[end]) {
                    count++;
                    start--;
                    end++;
                } else {
                    start = -1;
                }
            }

            if (i >= 1 && chars[i] == chars[i-1]){
                count++;
                start = i - 2;
                end = i + 1;
            }

            while (start >= 0 && end <= chars.length - 1) {
                if (chars[start] == chars[end]) {
                    count++;
                    start--;
                    end++;
                } else {
                    start = -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("//" + countSubstrings("aaa"));
    }
}
