class Solution {
    fun romanToInt(s: String): Int {
        var total = 0
        for (index in s.indices) {
            val current = value(s[index])
            val next = if (index < s.lastIndex) value(s[index + 1]) else 0
            total += if (current < next) -current else current
        }
        return total
    }

    private fun value(symbol: Char): Int = when (symbol) {
        'I' -> 1; 'V' -> 5; 'X' -> 10; 'L' -> 50
        'C' -> 100; 'D' -> 500; else -> 1000
    }
}
