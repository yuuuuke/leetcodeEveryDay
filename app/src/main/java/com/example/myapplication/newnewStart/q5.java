package com.example.myapplication.newnewStart;

//581
public class q5 {
    public int findUnsortedSubarray(int[] nums) {
        int[] maxList = new int[nums.length];
        int[] minList = new int[nums.length];
        maxList[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            maxList[index] = Math.max(nums[index], maxList[index - 1]);
        }
        minList[nums.length-1] = nums[nums.length-1];
        for(int index = nums.length-2;index >= 0;index --){
            minList[index] = Math.min(nums[index], minList[index + 1]);
        }


        int start = -1;
        int end = 0;

        int temp = Integer.MIN_VALUE;

        for (int index = nums.length - 1; index >= 0; index--) {
            if (temp == Integer.MIN_VALUE) {
                temp = nums[index];
                continue;
            }
            if (temp < maxList[index]) {
                start = index + 1;
                break;
            }else{
                temp = nums[index];
            }
        }
        temp = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (temp == Integer.MIN_VALUE) {
                temp = nums[index];
                continue;
            }
            if (temp > minList[index]) {
                end = index - 1;
                break;
            }else{
                temp = nums[index];
            }
        }
        System.out.println("start" + start + "end " + end);
        return start - end + 1;
    }
}
