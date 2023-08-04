package com.example.myapplication.newstart.day1;

import java.util.ArrayList;

public class q2 {
    public int[][] merge(int[][] intervals) {
        // 先按照头排序
        sort(0, intervals.length - 1, intervals);
        ArrayList<int[]> resultArray = new ArrayList<>(intervals.length);
        int[] result = null;
        for (int[] temp : intervals) {
            System.out.println(temp[0]);
            if (result == null) {
                result = new int[2];
                result[0] = temp[0];
                result[1] = temp[1];
            } else {
                if (result[1] > temp[0] && result[1] < temp[1]) {
                    result[1] = temp[1];
                } else if (result[1] < temp[0]) {
                    resultArray.add(result);
                    result = new int[2];
                    result[0] = temp[0];
                    result[1] = temp[1];
                }
            }
        }
        int[][] mergeResult = new int[resultArray.size()][2];
        for (int i = 0; i < resultArray.size(); i++) {
            mergeResult[i] = resultArray.get(i);
        }
        return mergeResult;
    }


    public void sort(int left, int right, int[][] intervals) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int center = intervals[start][0];
        while (start < end) {
            while (intervals[end][0] >= center && start < end) end--;
            // 交换
            if (start < end) {
                int[] temp = intervals[start];
                intervals[start] = intervals[end];
                intervals[end] = temp;
            }
            while (intervals[start][0] <= center && start < end) start++;
            // 交换
            if (start < end) {
                int[] temp = intervals[start];
                intervals[start] = intervals[end];
                intervals[end] = temp;
            }
        }
        sort(left, start - 1, intervals);
        sort(end + 1, right, intervals);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5};
        int[] nums2 = new int[]{2, 4};
        int[] nums3 = new int[]{4, 6};
        int[] nums4 = new int[]{3, 4};
        int[] nums5 = new int[]{0, 0};
        int[] nums6 = new int[]{1, 1};
        int[] nums7 = new int[]{3, 5};
        int[] nums8 = new int[]{2, 2};

        int[][] in = new int[][]{nums1, nums2,nums3,nums4,nums5,nums6,nums7,nums8};
        new q2().merge(in);
    }
}

// 42430132
// 22430134
//