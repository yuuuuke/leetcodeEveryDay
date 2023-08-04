package com.example.myapplication.old;

public class leetcode1419 {
    // croak
    public int minNumberOfFrogs(String croakOfFrogs) {
        int max = 0;
        int[] all = new int[5];
        char[] chars = croakOfFrogs.toCharArray();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            int index;
            if (chars[i] == 'r') {
                index = 1;
            } else if (chars[i] == 'o') {
                index = 2;
            } else if (chars[i] == 'a') {
                index = 3;
            } else if (chars[i] == 'k') {
                index = 4;
            } else if (chars[i] == 'c') {
                index = 0;
            } else {
                return -1;
            }
            all[index]++;
            if (index != 0) {
                if (all[index] > all[index - 1]) {
                    return -1;
                }
            }
            if (index == 0) {
                max = Math.max(max, all[0]);
            } else if (index == 4) {
                //一次叫完了
                all[0]--;
                all[1]--;
                all[2]--;
                all[3]--;
                all[4]--;
            }
        }
        int result = all[0];
        if (all[1] == result && all[2] == result && all[3] == result && all[4] == result) {
            return max;
        }
        return -1;
    }
}
