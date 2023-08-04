package com.example.myapplication.old;

public class leetcode312 {

    public static void main(String[] args) {

        char[] s = {'a', 'b', 'e', 'k', 'a', 'v'};
        int rl = 1;
        for (char c : s) {
            if (c > 48) {
                int shift = 1 << c;
                System.out.println(Integer.toBinaryString(shift) + "shift");
                int moveResult = shift | rl;
                System.out.println(Integer.toBinaryString(moveResult) + "moveResult");
                if (moveResult != rl) {
                    rl = moveResult;
                    System.out.println(Integer.toBinaryString(rl) + "rl");
                } else {
                    System.out.println("GGGG");
                    break;
                }
            }
        }
    }
}
