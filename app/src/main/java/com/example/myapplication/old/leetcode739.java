package com.example.myapplication.old;

import java.util.Arrays;

public class leetcode739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] time = new int[temperatures.length];
        //倒着找
        for (int i = time.length - 1; i >= 0; i--) {
            if (i == time.length - 1) {
                //最后一个，肯定是0
                time[i] = 0;
            } else {
                //前面的
                if (temperatures[i] < temperatures[i + 1]) {
                    time[i] = 1;
                } else {
                    //后一天比前一天温度低，找比后一天温度高的
                    time[i] = 0;
                    int temp = i + 1;
                    boolean isStop = false;
                    while (!isStop) {
                        System.out.println(i + "///" + temp);
                        if (temperatures[i] < temperatures[temp]) {
                            time[i] = temp - i;
                            isStop = true;
                        } else {
                            if (time[temp] == 0) {
                                time[i] = 0;
                                isStop = true;
                            } else {
                                //还是小
                                temp = temp + time[temp];
                                System.out.println("//" + temp);
                            }
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(time));
        }
        return time;
    }


    public static void main(String[] args) {
        System.out.print(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
