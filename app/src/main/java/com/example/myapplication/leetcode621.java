package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class leetcode621 {
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int time = 0;
        int alreadyRun = 0;

        int runTask = -1;
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char c : tasks) {
            if (countMap.get(c) == null) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, countMap.get(c) + 1);
            }
        }

        while (alreadyRun < tasks.length) {
            for (int i = 0; i < tasks.length; i++) {
                char task = tasks[i];
                if (task == '/') {
                    continue;
                }
                if (map.get(task) == null) {
                    if (countMap.get(task) > max) {
                        max = countMap.get(task);
                        countMap.put(task, countMap.get(task) - 1);
                        runTask = i;
                        break;
                    }
                } else {
                    int index = map.get(task);
                    if (time - index < n) {
                        runTask = -1;
                    } else if (time - index == n) {
                        runTask = i;
                        break;
                    } else {
                        if (countMap.get(task) > max) {
                            max = countMap.get(task);
                            countMap.put(task, countMap.get(task) - 1);
                            runTask = i;
                            break;
                        }
                    }
                }
            }
            if (runTask != -1) {
                alreadyRun++;
                map.put(tasks[runTask], time);
                tasks[runTask] = '/';
            }
            time++;
            System.out.println(Arrays.toString(tasks));
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println("//" + leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
