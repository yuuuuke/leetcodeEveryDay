package com.example.myapplication;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class leetcode621 {
    public static int leastInterval(char[] tasks, int n) {
        ArrayList<Integer> queue = new ArrayList<>(tasks.length * 2);
        int time = 0;
        int index = 0;

        int[] temp = new int[26];

        for (char c : tasks) {
            temp[c - 'A'] += 1;
        }

        System.out.println(Arrays.toString(temp));
        while (index < tasks.length) {
            if (queue.size() <= n) {
                boolean toNextTask = false;
                // 先取有重复的
                for (int i = 0; i < 26; i++) {
                    if (temp[i] > 1) {
                        if (!queue.contains(i)) {
                            //执行了
                            index++;
                            queue.add(i);
                            toNextTask = true;
                            temp[i] -= 1;
                            break;
                        }
                    }
                }
                if (!toNextTask) {
                    //没有重复的了，直接随便取一个就行了
                    for (int i = 0; i < 26; i++) {
                        if (temp[i] == 1) {
                            if (!queue.contains(i)) {
                                //执行了
                                index++;
                                toNextTask = true;
                                queue.add(i);
                                temp[i] -= 1;
                                break;
                            }
                        }
                    }
                }
                if (!toNextTask) {
                    queue.add(-1);
                }
            } else {
                // queue已经够了，优先找n+1的位置
                if (queue.get(queue.size() - n - 1) != -1 && temp[queue.get(queue.size() - n - 1)] >= 1) {
                    temp[queue.get(queue.size() - n - 1)] -= 1;
                    queue.add(queue.get(queue.size() - n - 1));
                    index++;
                } else {
                    // 先取有重复的
                    boolean toNextTask = false;
                    for (int i = 0; i < 26; i++) {
                        if (temp[i] > 1) {
                            int k = queue.indexOf(i);
                            if (k > queue.size() - n || k == -1) {
                                //执行了
                                index++;
                                queue.add(i);
                                toNextTask = true;
                                temp[i] -= 1;
                                break;
                            }
                        }
                    }
                    if (!toNextTask) {
                        //没有重复的了，直接随便取一个就行了
                        for (int i = 0; i < 26; i++) {
                            if (temp[i] == 1) {
                                int k = queue.indexOf(i);
                                if (k > queue.size() - n || k == -1) {
                                    //执行了
                                    index++;
                                    queue.add(i);
                                    temp[i] -= 1;
                                    toNextTask = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!toNextTask) {
                        queue.add(-1);
                    }
                }
            }
            System.out.println(queue);
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println("//" + leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
