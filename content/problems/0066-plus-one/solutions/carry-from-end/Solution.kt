class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (index in digits.lastIndex downTo 0) { if (digits[index] < 9) { digits[index]++; return digits }; digits[index] = 0 }
        return IntArray(digits.size + 1).also { it[0] = 1 }
    }
}
