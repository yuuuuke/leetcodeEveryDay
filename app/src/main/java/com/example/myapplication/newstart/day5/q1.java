package com.example.myapplication.newstart.day5;

public class q1 {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean hasSigned = false;
        boolean belowZero = false; // 是否是复数
        for (char c : chars) {
            if (c == ' ') {
                if(hasSigned){
                    break;
                }
            } else if (c >= 48 && c <= 57) {
                if (c == 48) {
                    // 是零
                    if (builder.length() == 0) {
                        hasSigned = true;
                    } else {
                        builder.append(c);
                    }
                } else {
                    hasSigned = true;
                    builder.append(c);
                }
            } else if (c == 45) {
                // 减号
                if (builder.length() == 0) {
                    if(hasSigned){
                        break;
                    }
                    belowZero = true;
                    hasSigned = true;
                } else {
                    break;
                }
            } else if (c == 43) {
                // 加号
                if (builder.length() == 0) {
                    if(hasSigned){
                        break;
                    }
                    belowZero = false;
                    hasSigned = true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (builder.length() == 0) {
            return 0;
        }
        if(builder.length() > 10){
            // 百分百超界了
            if(belowZero){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        long result = Long.parseLong(builder.toString());
        if (belowZero) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
