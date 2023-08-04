package com.example.myapplication.newstart.day1;

public class day1 {

    public boolean isPalindrome(int x) {
        char[] num = String.valueOf(x).toCharArray();
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            if (num[start] != num[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
