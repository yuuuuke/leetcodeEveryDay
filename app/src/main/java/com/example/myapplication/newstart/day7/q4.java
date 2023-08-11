package com.example.myapplication.newstart.day7;

import static com.example.myapplication.Utils.LogIntArray;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/description/
 * 排序一下， 然后取 n-1,n-3.n-5一直取完。
 * <p>
 * 复习一下快排把
 */
public class q4 {

    public int maxCoins(int[] piles) {
        quickSort(piles, 0, piles.length - 1);
        int count = piles.length / 3;
        LogIntArray(piles);
        int result = 0;
        for (int i = 0; i < count; i++) {
            result += piles[piles.length - 2 - 2 * i];
        }
        return result;
    }

    public void quickSort(int[] piles, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int center = piles[left];

        while (left < right) {
            while (piles[right] >= center && left < right) right--;
            if (right > left) {
                int temp = piles[right];
                piles[right] = piles[left];
                piles[left] = temp;
            }
            while (piles[left] < center && left < right) left++;
            if (right > left) {
                int temp = piles[right];
                piles[right] = piles[left];
                piles[left] = temp;
            }
        }

        quickSort(piles, start, left - 1);
        quickSort(piles, left + 1, end);
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{9,8,7,6,5,1,2,3,4};
        new q4().maxCoins(arrays);
    }
}
