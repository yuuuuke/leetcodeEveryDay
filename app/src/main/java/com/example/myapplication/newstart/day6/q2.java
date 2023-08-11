package com.example.myapplication.newstart.day6;

public class q2 {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int amass = 1;
        int temp = (int) Math.pow(10f, 5f);
        while (temp >= 1) {
            System.out.println("temp == " + temp + ",sum == " + sum + ",amass == " + amass);
            sum = sum + n / temp;
            amass = amass * (n / temp);
            n = n % temp;
            temp = temp / 10;
        }
        return amass - sum;
    }
}
