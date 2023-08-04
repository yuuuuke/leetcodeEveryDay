package com.example.myapplication.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode39 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        search(new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void search(List<Integer> current, int[] candidates, int target, int start) {
        for (int i = start; i < candidates.length; i++) {
            if (target > candidates[i]) {
                ArrayList<Integer> array = new ArrayList<>(current);
                array.add(candidates[i]);
                search(array, candidates, target - candidates[i], i);
            } else if (target == candidates[i]) {
                ArrayList<Integer> array = new ArrayList<>(current);
                array.add(candidates[i]);
                //结束
                list.add(array);
            }
        }
    }
}
