package com.example.myapplication;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class leetcode1224 {
    public static int maxEqualFreq(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (judge(map)) {
                max = i;
            }
        }
        return max + 1;
    }

    public static boolean judge(HashMap<Integer, Integer> map) {
        if (map.size() == 1) {
            return true;
        }
        int ave = -1;
        int aveTime = 0;
        int other = -1;
        int otherTime = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (ave == -1) {
                ave = entry.getValue();
                aveTime++;
                continue;
            }
            if (ave != entry.getValue()) {
                if (other == -1) {
                    other = entry.getValue();
                    otherTime++;
                } else {
                    if (other == entry.getValue()) {
                        otherTime++;
                    } else {
                        return false;
                    }
                }
            } else {
                aveTime++;
            }
        }
        System.out.println(ave + "." + other + "." + aveTime + "." + otherTime);
        if(aveTime == 0 && other == 1){
            return true;
        }
        if(otherTime == 0 && ave == 1){
            return true;
        }
        if (aveTime != 1 && otherTime != 1) {
            return false;
        }
        System.out.println(ave + "." + other + "." + aveTime + "." + otherTime);
        //只有两个 且其中一个是1
        if (aveTime > otherTime) {
            if (other - ave == 1) {
                return true;
            }
            return other == 1;
        } else if (aveTime < otherTime) {
            if (ave - other == 1) {
                return true;
            }
            return ave == 1;
        } else {
            System.out.println(ave + "." + other);
            return Math.abs(ave - other) == 1;
        }


//        HashMap<Integer, Integer> map1 = new HashMap<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (map1.get(entry.getValue()) == null) {
//                map1.put(entry.getValue(), 1);
//            } else {
//                map1.put(entry.getValue(), map1.get(entry.getValue()) + 1);
//            }
//        }
//        Iterator<Map.Entry<Integer, Integer>> iterator1 = map1.entrySet().iterator();
//        if(map1.size() == 1){
//            return iterator1.next().getKey() == 1;
//        }
//        if (map1.size() != 2) {
//            return false;
//        } else {
//            Map.Entry<Integer, Integer> ave = iterator1.next();
//            Map.Entry<Integer, Integer> other = iterator1.next();
//            if (ave.getValue() == 1) {
//                if (ave.getKey() - other.getKey() == 1) {
//                    return true;
//                }
//                if (ave.getKey() == 1) {
//                    return true;
//                }
//            }
//            if (other.getValue() == 1) {
//                if (other.getKey() - ave.getKey() == 1) {
//                    return true;
//                }
//                return other.getKey() == 1;
//            }
//        }
//        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxEqualFreq(new int[]{1,2}));
    }
}
