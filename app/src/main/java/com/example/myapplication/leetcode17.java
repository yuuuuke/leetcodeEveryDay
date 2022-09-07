package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class leetcode17 {

    /*
    2 abc
    3 def
    4 ghi
    5 jkl
    6 mno
    7 pqrs
    8 tuv
    9 wxyz
     */

    public static List<String> letterCombinations(String digits) {

        List<String> combin = new ArrayList<>();

        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});

        char[] list = digits.toCharArray();

        if (list.length <= 0) {
            return combin;
        }

        combin = Arrays.asList(map.get(Integer.parseInt(list[0] + "")));

        for (int i = 1; i < list.length; i++) {
            combin = add(combin, map.get(Integer.parseInt(list[i] + "")));
        }
        return combin;
    }

    public static List<String> add(List<String> list, String[] chars) {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : list) {
            for (String c : chars) {
                strings.add(s + c);
            }
        }
        return strings;
    }
}
