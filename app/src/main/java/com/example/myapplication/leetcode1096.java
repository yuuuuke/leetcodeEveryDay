package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class leetcode1096 {
    // 从后往前读取吧
    public List<String> braceExpansionII(String expression) {
        char[] chars = expression.toCharArray();
        int index = expression.length() - 1;
        List<String> result = new ArrayList<>(20);
        List<String> start = new ArrayList<>(10);
        List<String> temp = new ArrayList<>(20);
        while (index > 0) {
            if (judgeSymbol(chars[index]) == 0) {

            }
            index--;
        }
        return result;
    }

    /**
     * 判断当前是什么符号
     *
     * @return 0 字母，1 逗号，2 前括号 ，3 后括号
     */
    public int judgeSymbol(char c) {
        if (c == '{') {
            return 2;
        } else if (c == '}') {
            return 3;
        } else if (c == ',') {
            return 1;
        } else {
            return 0;
        }
    }
}
