package com.example.myapplication.newstart.day5;

public class q2 {
    public String intToRoman(int num) {
        int I = 1;
        int IV = 4;
        int V = 5;
        int IX = 9;
        int X = 10;
        int XL = 40;
        int L = 50;
        int XC = 90;
        int C = 100;
        int CD = 400;
        int D = 500;
        int CM = 900;
        int M = 1000;

        StringBuilder builder = new StringBuilder();

        if (num >= M) {
            int count = num / M;
            for (int i = 0; i < count; i++) {
                builder.append("M");
            }
            num = num % M;
        }
        if (num >= CM) {
            builder.append("CM");
            num = num - CM;
        }

        if (num >= D) {
            int count = num / D;
            for (int i = 0; i < count; i++) {
                builder.append("D");
            }
            num = num % D;
        }
        if (num >= CD) {
            builder.append("CD");
            num = num - CD;
        }

        if (num >= C) {
            int count = num / C;
            for (int i = 0; i < count; i++) {
                builder.append("C");
            }
            num = num % C;
        }
        if (num >= XC) {
            builder.append("XC");
            num = num - XC;
        }

        if (num >= L) {
            int count = num / L;
            for (int i = 0; i < count; i++) {
                builder.append("L");
            }
            num = num % L;
        }
        if (num >= XL) {
            builder.append("XL");
            num = num - XL;
        }

        if (num >= X) {
            int count = num / X;
            for (int i = 0; i < count; i++) {
                builder.append("X");
            }
            num = num % X;
        }
        if (num >= IX) {
            builder.append("IX");
            num = num - CM;
        }

        if (num >= V) {
            int count = num / V;
            for (int i = 0; i < count; i++) {
                builder.append("V");
            }
            num = num % V;
        }
        if (num >= IV) {
            builder.append("IV");
            num = num - IV;
        }
        if (num >= I) {
            int count = num / I;
            for (int i = 0; i < count; i++) {
                builder.append("I");
            }
        }
        return builder.toString();
    }
}
