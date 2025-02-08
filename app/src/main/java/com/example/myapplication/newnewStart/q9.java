package com.example.myapplication.newnewStart;

//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class q9 {
    public int maxProfit(int[] prices) {
        /**
         * i 天，dp[i][0]为，当前持有一个股票，dp[i][1]为，当前未持有股票，dp[i][2]为，当前为冷冻期
         * 如果dp[i][0]
         * 那么第i天的收益为
         * 1、前一天已经持有一个股票了，所以今天和昨天是一样的，dp[i-1][0]
         * 2、昨天为冷冻或者未持有，那么今天要购买一个股票，所以就是dp[i-1][1]-prices[i]或者dp[i-1][2]-prices[i]
         *
         * 那么如果是dp[i][1]
         * 1、如果昨天没有持有
         *  dp[i-1][1]
         * 2、昨天是冷冻期
         *  dp[i-1][2]
         * 3、昨天持有
         *  dp[i-1][0]+prices[i]
         *
         *  如果是dp[i][2]
         *  那么只能是昨天卖出了
         *  就是 dp[i-1][1]
         */
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][0] + prices[i]);
            dp[i][2] = dp[i - 1][1];
        }
        return Math.max(dp[prices.length - 1][0], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
