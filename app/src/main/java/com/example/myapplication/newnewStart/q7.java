package com.example.myapplication.newnewStart;

import java.util.HashMap;

public class q7 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tTimes = new HashMap<>();
        for(char c : t.toCharArray()){
            if(tTimes.get(c) == null){
                tTimes.put(c,1);
            }else{
                tTimes.put(c,tTimes.get(c)+1);
            }
        }
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();

        int resultLeft = 0;
        int resultRight = -1;

        HashMap<Character,Integer> map = new HashMap<>();
        //记录双指针内部符合条件字符数量
        int count = 0;
        while(true){
            if(count < t.length()){
                // 不满足条件。right往右移动
                if(tTimes.get(chars[right]) != null && tTimes.get(chars[right]) > 0){
                    // 包含某个字符
                    count ++;
                    if(map.get(chars[right]) == null){
                        map.put(chars[right],1);
                    }else{
                        map.put(chars[right],tTimes.get(chars[right])+1);
                    }
                }
                if(count < t.length()){
                    //如果已经包含了，则right不再往右移动了
                    right ++;
                }
            }else{
                if(resultRight - resultLeft> right-left){
                    // 获取最小值
                    resultRight = right;
                    resultLeft = left;
                }
                // 满足条件了，left开始移动
//                if()
            }

            // 结束条件：right已经在最右边了，且count < t.length
            if(right == chars.length-1 && count < t.length()){

            }
        }
    }
}
