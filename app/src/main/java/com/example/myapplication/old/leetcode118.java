package com.example.myapplication.old;

import java.util.ArrayList;
import java.util.List;

public class leetcode118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> last = result.get(i - 2);
            for (int j = 0; j < i; j++) {
                if (j == 0 || (j == i - 1)) {
                    //第一位和最后一位肯定是1
                    list.add(1);
                } else {
                    list.add(last.get(j - 1) + last.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
