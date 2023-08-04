package com.example.myapplication.old;

public class leetcode10 {

    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        // p匹配的范围可能是大于s的，所以要从 p 开始遍历，当第一个位置符合时候，进入匹配，如果最后都 index 都还没有==s的index ，那么就匹配失败了，否则成功
        int i = 0;
        int index = 0;
        while (i < p.length()) {
            if (pChars[i] == '.') {
                //全匹配，next
                i++;
                index++;
            } else if (pChars[i] == '*') {
                if (i == 0) {
                    i++;
                    continue;
                }
                if (pChars[i - 1] == '.') {
                    //开始匹配
                    index++;
                    if(index > pChars.length) return true;
                    while (sChars[index] == sChars[index - 1]) {
                        index++;
                        if(index > pChars.length) return true;
                    }
                } else {
                    if (pChars[i - 1] == sChars[index]) {
                        //开始循环
                        index++;
                        if(index > pChars.length) return true;
                        while (sChars[index] == sChars[index - 1]) {
                            index++;
                            if(index > pChars.length) return true;
                        }
                    } else {
                        i++;
                        index = 0;
                    }
                }
            } else {
                if (pChars[i] == sChars[index]) {
                    if (index == s.length() - 1) {
                        return true;
                    } else {
                        if (i == p.length() - 1) {
                            return false;
                        }
                    }
                    i++;
                    index++;
                    if(index > pChars.length) return true;
                } else {
                    i++;
                    index = 0;
                }
            }
        }
        if (index == s.length() - 1) {
            return true;
        } else {
            return false;
        }
    }

}
