package com.example.myapplication.newnewStart;

import java.util.Arrays;

public class q11 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[coins.length];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin : coins) {
            dp[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount];
    }
}
