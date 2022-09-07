package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        dp(list, n * 2, "(", 1);
        return list;
    }

    public void dp(ArrayList<String> list, int max, String builder, int num) {
        if (builder.length() == max) {
            //结束了
            if (num == 0) {
                list.add(builder);
            }
            return;
        }

        if (num > 0) {
            dp(list, max, builder + "(", num + 1);
            dp(list, max, builder + ")", num - 1);
        } else {
            dp(list, max, builder + "(", num + 1);
        }
    }
}
