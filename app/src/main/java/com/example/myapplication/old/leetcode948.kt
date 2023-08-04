package com.example.myapplication.old

import java.util.*

class leetcode948 {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        if (tokens.isEmpty()) {
            return 0
        }
        var pow = power
        var start = 0
        var end = tokens.size - 1
        Arrays.sort(tokens)
        var result = 0
        while (start <= end) {
            if (tokens[start] <= pow) {
                result++
                start++
                pow -= tokens[start]
            } else {
                if (start == end) {
                    return result
                }
                if (result >= 1) {
                    if (pow + tokens[end] > tokens[start]) {
                        result--
                        pow += tokens[end]
                        end--
                    } else {
                        return result
                    }
                } else {
                    return result
                }
            }
        }
        return result
    }
}