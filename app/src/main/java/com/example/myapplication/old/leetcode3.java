package com.example.myapplication.old;

import android.util.Log;

import java.util.HashMap;

public class leetcode3 {

    static int[] address = new int[128];

    public static int lengthOfLongestSubstring(String s) {

        for (int i = 0; i < 128; i++) {
            address[i] = -1;
        }

        int length = 1;
        int tempLength = 1;
        int start = 0;
        int end = 0;
        char[] charList = s.toCharArray();
        while (true) {
            address[charList[end]] = end;
            end++;
            if (end >= s.length()) {
                return Math.max(tempLength, length);
            }
            int index = isRepeat(charList[end]);
            if(index < start){
                index = -1;
            }
            if (index == -1) {
                //没有重复
                tempLength++;
            } else {
                //char[end]跟 charList[index]
                if (tempLength > length) {
                    length = tempLength;
                }
                start = index + 1;
                tempLength = end - start + 1;
            }
            if (s.length() - start < length) {
                return length;
            }
        }
    }

    private static int isRepeat(char end) {
        if (address[end] != -1) {
            return address[end];
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba") + "///");
    }
}
