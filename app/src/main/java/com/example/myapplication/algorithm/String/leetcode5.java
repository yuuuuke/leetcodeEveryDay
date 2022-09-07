package com.example.myapplication.algorithm.String;

public class leetcode5 {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (end > start) {
            while (!judge(chars[start])) {
                start++;
                if(start > s.length()-1){
                    return true;
                }
            }
            while(!judge(chars[end])){
                end--;
                if(end < 0){
                    return true;
                }
            }
            if(end > start){
                if(equal(chars[start],chars[end])){
                    start ++;
                    end --;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean judge(char a) {
        return (48 <= a && a <= 57) || (65 <= a && a <= 90) || (97 <= a && a <= 122);
    }

    public boolean equal(char a, char b) {
        if (a == b) {
            return true;
        } else if (((65 <= a && a <= 90) || (97 <= a && a <= 122)) && ((65 <= b && b <= 90) || (97 <= b && b <= 122))) {
            return Math.abs(a - b) == 32;
        } else {
            return false;
        }
    }
}
