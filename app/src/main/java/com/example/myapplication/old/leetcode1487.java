package com.example.myapplication.old;

import java.util.HashMap;

public class leetcode1487 {

    public String[] getFolderNames(String[] names) {
        String[] result = new String[names.length];

        int index = 0;
        String name = names[0];
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            if (map.get(name) == null) {
                map.put(name, 1);
                result[index] = name;
                index++;
                name = names[index];
            } else {
                //不是空
                int num = map.get(name);
                for (int i = 0; i < index; i++) {
                    if ((name + "(" + num + ")").equals(result[i])) {
                        num++;
                        i = 0;
                    }
                }
                name = name + "(" + num + ")";
                map.put(name, num + 1);
                index++;
            }
            if (index == names.length)
                break;
        }
        return result;
    }
}
