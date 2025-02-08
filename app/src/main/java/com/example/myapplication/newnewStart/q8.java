package com.example.myapplication.newnewStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q8 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dsf(result,0,nums,new ArrayList<>());
        return result;
    }

    public void dsf(List<List<Integer>> result,int index,int[] nums,List<Integer> list){
        if(index >= nums.length){
            return;
        }
        boolean[] used = new boolean[21];
        for(int i = index;i<nums.length;i++){
            if(!used[nums[i]+10]){
                used[nums[i]+10] = true;
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                result.add(temp);
                dsf(result,i+1,nums,temp);
            }
        }
    }
}
