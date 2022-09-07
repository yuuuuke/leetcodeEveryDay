package com.example.myapplication;

public class leetcode278 {
    public static int firstBadVersion(int n) {
        return found(1, n);
    }

    private static int found(int start, int end) {
        System.out.println(start + "/" + end);
        if (isBadVersion(start) && end - start <= 1) {
            return start;
        }
        if (isBadVersion(end) && end - start <= 1) {
            return end;
        }
        int center = start + (end - start) /2;
        if (isBadVersion(center)) {
            return found(start, center);
        } else {
            return found(center, end);
        }
    }

    private static boolean isBadVersion(int num) {
        return num == 1702766719;
    }

    public static void main(String[] args) {
        firstBadVersion(2126753390);
    }
}
