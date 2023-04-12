package com.example.myapplication.algorithm.hash;

import java.util.HashSet;

public class leetcode202 {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int temp = n;
        while (set.add(temp) && temp != 1) {
            temp = js(temp);
            if(temp == 0){
                return false;
            }
        }
        return temp == 1;
    }

    private static int js(int num) {
        int result = 0;
        long i = 1;
        while (num % (i * 10) != num || num / i != 0) {
            System.out.println(i);
            result += (num % (i * 10) / i) * (num % (i * 10) / i);
            i = i * 10;
        }
        return result;
    }

    public static void main(String[] args) {
       System.out.println( isHappy(1999999999));
    }
}
