package com.example.myapplication.old

class leetcode1615 {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val map = HashMap<Int, Int>()
        for (array in roads) {
            if (map[array[0]] == null) {
                map[array[0]] = 1
            } else {
                map.put(array[0], map.get(array[0])!! + 1)
            }
            if (map[array[1]] == null) {
                map[array[1]] = 1
            } else {
                map.put(array[1], map.get(array[1])!! + 1)
            }
        }

        var max = 0
        var need = false
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                need = false
                for (array in roads) {
                    if ((array[0] == i && array[1] == j) || (array[1] == i && array[0] == j)) {
                        max = max.coerceAtLeast((map[i]!! + map[j]!! - 1))
                        need = true
                        break
                    }
                }
                if(!need){
                    max = max.coerceAtLeast((map[i]?:0) + (map[j]?:0))
                }
            }
        }
        return max
    }
}
fun main(args: Array<String>) {

}