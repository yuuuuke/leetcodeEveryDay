package com.example.myapplication.newnewStart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 621
public class q4 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        boolean[] taskRunning = new boolean[26];
        LinkedList<Integer> RunningTask = new LinkedList<>();
        int time = 0;
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        while (true) {
            //找到任务最多且不在冷却状态的任务
            int maxCount = 0;
            int maxTask = -1;
            for (int index = 0; index < 26; index++) {
                if(taskCount[index] > maxCount && !taskRunning[index]){
                    maxCount = taskCount[index];
                    maxTask = index;
                }
            }
            // 下个执行maxTask
            if(maxTask == -1){
                // 没有可执行的任务了,判断是否已经结束了
                boolean isFinish = true;
                for(Integer task : RunningTask){
                    if(task!=-1 && taskCount[task] != 0){
                        isFinish = false;
                        break;
                    }
                }
                if(isFinish){
                    // 结束了
                    return time;
                }else{
                    // 上个任务冷却结束
                    if(RunningTask.size() == n){
                        int last = RunningTask.pollLast();
                        if(last != -1){
                            taskRunning[last] = false;
                        }
                    }
                    // 轮空
                    time++;
                    RunningTask.push(-1);
                }
            }else{
                // 上个任务冷却结束
                if(RunningTask.size() == n){
                    int last = RunningTask.pollLast();
                    if(last != -1){
                        taskRunning[last] = false;
                    }
                }
                // 执行maxTask这个任务
                taskCount[maxTask]--;
                RunningTask.push(maxTask);
                taskRunning[maxTask] = true;
                time++;
            }
        }
    }
}
