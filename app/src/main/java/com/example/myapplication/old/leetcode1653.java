package com.example.myapplication.old;

public class leetcode1653 {

    public int minimumDeletions(String s) {
        int result = 0;
        int bCount = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'a') {
                result = Math.min(result + 1, bCount);
            } else {
                bCount++;
            }
        }
        return result;
    }
}
