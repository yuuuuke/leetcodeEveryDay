package com.example.myapplication.newstart.day11;

/**
 * https://leetcode.cn/problems/perfect-squares/description/
 * 背包问题
 */
public class q2 {

    public static void main(String[] args) {
        System.out.println(numSquares());
    }

    public static int numSquares() {
        int diff = 445;
        int start = 151621;
        int sum = 0;
        while(start > 0){
            sum+=start;
            start -= diff;
            diff++;
        }
        return sum;
    }
}
