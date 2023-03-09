package com.example.myapplication;

public class leetcode122 {


    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max && prices[i] > min) {
                max = prices[i];
            } else {
                if(max != 0){
                    //可以卖出了
                    result = result + max - min;
                    max = 0;
                }else{
                    min = prices[i];
                }
            }
            if(i == prices.length-1){
                //最后了
                if(max > min){
                    result = result + max - min;
                }
            }
        }
        return result;
    }
}
