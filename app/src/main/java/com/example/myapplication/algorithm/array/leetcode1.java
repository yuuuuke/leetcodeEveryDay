package com.example.myapplication.algorithm.array;

public class leetcode1 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        //{1,0,0,0 ...}
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
