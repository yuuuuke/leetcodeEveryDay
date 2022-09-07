package com.example.myapplication;

public class leetcode11 {

    public static int maxArea(int[] height) {
        int area = 0;
        //两次循环吧
        for (int i = 0; i < height.length - 1; i++) {
            //先跟最后一位比，如果最后一位大，那就结束了
            if (height[i] <= height[height.length - 1]) {

                area = Math.max(area, (height.length - i - 1) * height[i]);
                continue;
            }
            //从后往前找最高的
            int max = 0;
            for (int j = height.length - 1; j > i; j--) {
                if (max < height[j]) {
                    area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
