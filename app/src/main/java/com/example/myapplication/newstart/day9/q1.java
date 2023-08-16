package com.example.myapplication.newstart.day9;

import java.util.Stack;

/**
 * 单调栈 ① https://leetcode.cn/problems/daily-temperatures/
 */
public class q1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.empty()) {
                stack.push(i);
            } else {
                if (temperatures[i] <= temperatures[stack.peek()]) {
                    //入栈
                    stack.push(i);
                } else {
                    //出栈
                    while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                        result[stack.peek()] = i - stack.pop();
                    }
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
