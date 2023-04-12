package com.example.myapplication

import java.util.*
import kotlin.collections.ArrayList

class leetcode1630 {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val list = ArrayList<Boolean>(l.size)
        for (i in l.indices) {
            val start = l[i]
            val end = r[i]
            if (end - start <= 1) {
                list.add(true)
                continue
            }
            val temp = IntArray(end - start + 1)
            for ((index, j) in (start..end).withIndex()) {
                temp[index] = nums[j]
            }
            Arrays.sort(temp)
            for (j in 2 until temp.size) {
                if (temp[j] - temp[j - 1] != temp[1] - temp[0]) {
                    list.add(false)
                    break
                }
            }
            if (list.size < i + 1) {
                list.add(true)
            }
        }
        return list
    }
}