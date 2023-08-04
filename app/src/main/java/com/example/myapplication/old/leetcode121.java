package com.example.myapplication.old;

public class leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        //最大利润
        int max = prices[1] - prices[0];
        int min = Math.min(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            max = Math.max(prices[i] - min, max);
        }
        return Math.max(max, 0);
    }
}
