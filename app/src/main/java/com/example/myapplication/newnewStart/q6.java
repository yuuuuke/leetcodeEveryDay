package com.example.myapplication.newnewStart;

import java.util.HashMap;

public class q6 {
    // 560 前缀和
    public int subarraySum(int[] nums, int k) {
        int[] frontSums = new int[nums.length];
        int frontSum = 0;
        for (int index = 0; index < nums.length; index++) {
            frontSum += nums[index];
            frontSums[index] = frontSum;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i!=0){
                if(frontSums[i] == k){
                    result++;
                }
            }
            for (int j = i+1; j < nums.length; j++) {
                if(i == j){
                    if(nums[i] == k){
                        result++;
                    }
                }else{
                    if(frontSums[j]-frontSums[i] == k){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
