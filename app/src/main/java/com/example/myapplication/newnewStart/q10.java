package com.example.myapplication.newnewStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/?envType=daily-question&envId=2025-02-06
 */
public class q10 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dsf(result,new boolean[nums.length],nums,new ArrayList<>());
        return result;
    }

    public void dsf(List<List<Integer>> result,boolean[] signed,int[] nums,List<Integer> list){
        if(list.size() == nums.length){
            result.add(list);
            return;
        }
        boolean[] used = new boolean[21];
        for(int i = 0;i<nums.length;i++){
            if(!used[nums[i]+10] && !signed[i]){
                used[nums[i]+10] = true;
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                boolean[] temp1 = Arrays.copyOf(signed,signed.length);
                temp1[i] = true;
                dsf(result,temp1,nums,temp);
            }
        }
    }
}
