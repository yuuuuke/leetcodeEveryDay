package com.example.myapplication.old;

import java.util.ArrayList;
import java.util.List;

public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int last = strs.length;
        while (last > 0) {
            List<String> temp = new ArrayList<>();
            int[] numbers = null;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null) {
                    if (numbers == null) {
                        numbers = new int[26];
                        for (char c : strs[i].toCharArray()) {
                            numbers[c - 'a']++;
                        }
                        temp.add(strs[i]);
                        last--;
                        strs[i] = null;
                    } else {
                        int[] tempNumbers = numbers.clone();
                        boolean isAdd = true;
                        for (char c : strs[i].toCharArray()) {
                            if (tempNumbers[c - 'a'] == 1) {
                                tempNumbers[c - 'a'] = 0;
                            } else {
                                isAdd = false;
                                break;
                            }
                        }

                        if (isAdd) {
                            temp.add(strs[i]);
                            last--;
                            strs[i] = null;
                        } else {
                            continue;
                        }

                        for (int k : tempNumbers) {
                            if (k == 1) {
                                isAdd = false;
                                break;
                            }
                        }
                        if (isAdd) {
                            temp.add(strs[i]);
                            last--;
                            strs[i] = null;
                        }
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}
