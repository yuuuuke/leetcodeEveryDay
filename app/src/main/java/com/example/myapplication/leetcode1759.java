package com.example.myapplication;

public class leetcode1759 {
    public static void main(String[] args) {

    }

    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int count = 0;
        while (true) {
            if (chars[start] == chars[end] && end < chars.length-1) {
                end++;
            } else {
                count += js(end - start + 1);
                start = end + 1;
                end = end + 1;
            }
            if (start >= chars.length) {
                return count;
            }
        }
    }

    public int js(int i) {
        return (1 + i) * i / 2;
    }
}
