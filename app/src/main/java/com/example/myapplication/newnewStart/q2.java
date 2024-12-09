package com.example.myapplication.newnewStart;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/">...</a>
 */
public class q2 {
    public int longestConsecutive(int[] nums) {
        if(nums.length <=0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 1;
        for (int num : nums) {
            map.put(num, num);
        }
        for (int num : nums) {
            int max = 0;
            if (map.get(num - 1) == null && map.get(num + 1) != null) {
                while (map.get(num) != null) {
                    max++;
                    num++;
                }
            }
            result = Math.max(max, result);
        }
        return result;
    }
}
