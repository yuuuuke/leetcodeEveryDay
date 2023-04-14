package com.example.myapplication;

public class leetcode10 {

    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        // p匹配的范围可能是大于s的，所以要从 p 开始遍历，当第一个位置符合时候，进入匹配，如果最后都 index 都还没有==s的index ，那么就匹配失败了，否则成功

        int i = 0;

        return true;
    }

}
