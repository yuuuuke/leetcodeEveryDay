package com.example.myapplication.interview

/**
 * 面试题 0502 题
 */
class Q0502 {
    fun printBin(i: Double): String? {
        val stringBuilder = StringBuilder("0.")
        var num = i
        var temp = 0.5
        while (true) {
            if (num - temp == 0.0) {
                //结束了
                stringBuilder.append("1")
                return stringBuilder.toString()
            } else if (num - temp > 0.0) {
                num -= temp
                stringBuilder.append("1")
            } else {
                stringBuilder.append("0")
            }
            temp *= 0.5
            if (stringBuilder.length > 34) {
                return "ERROR"
            }
        }
    }
}