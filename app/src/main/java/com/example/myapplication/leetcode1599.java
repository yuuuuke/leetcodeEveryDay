package com.example.myapplication;

public class leetcode1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (runningCost > boardingCost * 4) {
            return -1;
        }
        int count = -1;
        int result = 0;
        int current = 0;
        int memberCount = 0;

        for (int i = 0; ; i++) {
            if (i < customers.length) {
                memberCount = memberCount + customers[i];
            }else{
                if(memberCount == 0){
                    break;
                }
            }
            if (memberCount > 4) {
                current = current + 4 * boardingCost - runningCost;
                memberCount = memberCount - 4;
            } else {
                current = current + memberCount * boardingCost - runningCost;
                memberCount = 0;
            }
            if (current > result) {
                count = i+1;
                result = current;
            }
        }
        return count;
    }
}
