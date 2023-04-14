package com.example.myapplication;

/**
 * 接雨水
 */
public class leetcode42 {
    //左右两边有比这个柱子高的，这个柱子就可以储水，且储水量是 左右两边较小的那个 - 自己

    public int trap(int[] height) {
        int result = 0;
        if (height.length <= 2) {
            return result;
        }
        int[] leftMaxs = new int[height.length - 1];
        int[] rightMaxs = new int[height.length ];

        int leftMax = leftMaxs[0] = height[0];
        int rightMax = rightMaxs[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length - 1; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxs[i] = leftMax;
        }
        for (int i = height.length - 2; i > 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMaxs[i] = rightMax;
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < leftMaxs[i - 1] && height[i] < rightMaxs[i + 1]) {
                result += Math.min(leftMaxs[i - 1], rightMaxs[i + 1]) - height[i];
            }
        }
        return result;
    }
}
