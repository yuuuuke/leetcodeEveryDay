package com.example.myapplication;

public class leetcode2379 {
    public static int minimumRecolors(String blocks, int k) {
        int result = 0;
        int last = 0;
        char[] chars = blocks.toCharArray();
        result = findW(chars, k);
        if (result == 0) {
            return 0;
        }
        last = result;
        for (int i = 1; i <= chars.length - k; i++) {
            last = last + (chars[i - 1] == 'W' ? -1 : 0) + (chars[i + k - 1] == 'W' ? 1 : 0);
            result = Math.min(last, result);
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        minimumRecolors("WWBBBWBBBBBWWBWWWB", 16);
    }

    private static int findW(char[] chars, int end) {
        int wCount = 0;
        for (int i = 0; i < end; i++) {
            if (chars[i] == 'W') {
                wCount++;
            }
        }
        return wCount;
    }
}
