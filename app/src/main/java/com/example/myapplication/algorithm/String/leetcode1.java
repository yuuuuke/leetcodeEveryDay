package com.example.myapplication.algorithm.String;

public class leetcode1 {
    public void reverseString(char[] s) {
        if (s.length == 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        char temp;
        while (j > i){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            j --;
            i ++;
        }
    }
}
