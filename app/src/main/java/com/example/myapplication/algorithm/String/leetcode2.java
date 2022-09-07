package com.example.myapplication.algorithm.String;

public class leetcode2 {
    public static int reverse(int x){
        String numString = String.valueOf(x);
        char[] chars = numString.toCharArray();
        int start,end;
        if(chars[0] == '-'){
            start = 1;
        }else{
            start = 0;
        }
        end = chars.length -1;
        while(end > start){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            end --;
            start ++;
        }
        String resultString = String.valueOf(chars);
        try{
            int result = Integer.parseInt(resultString);
            return result;
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
