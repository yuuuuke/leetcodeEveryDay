package com.example.myapplication.algorithm.String;

import android.util.Log;

import java.util.HashSet;

public class leetcode3 {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean isRepeat = false;
            for (int j = 0; j < chars.length; j++) {
                if(i == j){
                    continue;
                }
                if(chars[i] == chars[j]){
                    isRepeat = true;
                    break;
                }
            }
            if(!isRepeat){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
