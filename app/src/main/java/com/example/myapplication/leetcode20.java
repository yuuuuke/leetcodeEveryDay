package com.example.myapplication;

import java.util.Stack;

public class leetcode20 {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if(chars.length == 0){
            return true;
        }
        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c + "");
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if(c == '}'){
                    if(stack.peek().equals("{")){
                        stack.pop();
                    }else{
                        return false;
                    }
                }

                if(c == ')'){
                    if(stack.peek().equals("(")){
                        stack.pop();
                    }else{
                        return false;
                    }
                }

                if(c == ']'){
                    if(stack.peek().equals("[")){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
