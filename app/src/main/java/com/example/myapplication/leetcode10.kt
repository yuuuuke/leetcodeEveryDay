package com.example.myapplication

class leetcode10 {
    fun isMatch(s: String, p: String): Boolean {
        var isAll = false
        var sCursor = 0
        var pCursor = 0
        for (c in s.indices) {

            try {
                val sChar = s[sCursor]
                val pChar = p[pCursor]

                if (sChar == pChar) {
                    //通过检测，检测下一位
                    sCursor++
                    pCursor++
                    continue
                }

                if (pChar == '.') {
                    //全匹配
                    sCursor++
                    pCursor++
                    continue
                }

                if (pChar == '*') {
                    if (s[sCursor] == p[pCursor - 1] || p[pCursor - 1] == '.') {
                        isAll = true
                        sCursor++
                        continue
                    } else {
                        if(isAll){
                            isAll = false
                            pCursor++
                            continue
                        }else{
                            return false
                        }
                    }
                }
                return false
            } catch (e: Exception) {
                return false
            }
        }
        return true
    }
}