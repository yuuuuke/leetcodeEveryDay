package com.example.myapplication.newstart.day11;

public class q1 {
    public int maxDistToClosest(int[] seats) {
        int lastOne = -1;
        int max = 0;
        for (int index = 0; index < seats.length; index++) {
            if (seats[index] == 1) {
                if (lastOne == -1) {
                    max = index;
                } else {
                    max = Math.max(max, (index - lastOne) / 2);
                }
                lastOne = index;
            }
        }
        max = Math.max(max, seats.length -1 - lastOne);
        return max;
    }
}
