package com.example.myapplication.old;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        search(new ArrayList<>(), nums, new ArrayList<>());
        return list;
    }

    public void search(List<Integer> alIndex, int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            // 结束
            list.add(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            boolean already = false;
            for (int j = 0; j < alIndex.size(); j++) {
                if (i == alIndex.get(j)) {
                    already = true;
                    break;
                }
            }
            if (already) {
                continue;
            }
            List<Integer> tempIndex = new ArrayList<>(alIndex);
            tempIndex.add(i);
            List<Integer> tempResult = new ArrayList<>(temp);
            tempResult.add(nums[i]);
            search(tempIndex, nums, tempResult);
        }
    }
}
