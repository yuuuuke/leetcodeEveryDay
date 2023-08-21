package com.example.myapplication.newstart.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/
 */
public class q1 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int start, int[] nums, ArrayList<Integer> last, ArrayList<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            ArrayList<Integer> next = new ArrayList<>(last);
            next.add(nums[i]);
            result.add(next);
            dfs(i + 1, nums, next, result);
        }
    }
}
