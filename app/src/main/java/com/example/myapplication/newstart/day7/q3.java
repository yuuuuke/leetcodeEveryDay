package com.example.myapplication.newstart.day7;

/**
 * https://leetcode.cn/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/
 */
public class q3 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int i : left) {
            max = Math.max(max, i);
        }
        for (int i : right) {
            max = Math.max(max, n - i);
        }
        return max;
    }
}
