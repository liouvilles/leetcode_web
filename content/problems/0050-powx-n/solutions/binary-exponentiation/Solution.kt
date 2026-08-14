class Solution {
    fun myPow(input: Double, n: Int): Double {
        var base = input; var power = n.toLong(); if (power < 0) { base = 1.0 / base; power = -power }
        var answer = 1.0
        while (power > 0) { if (power and 1L == 1L) answer *= base; base *= base; power = power shr 1 }
        return answer
    }
}
