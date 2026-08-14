class Solution {
    fun decodeString(s: String): String {
        val counts = ArrayDeque<Int>(); val prefixes = ArrayDeque<StringBuilder>(); var current = StringBuilder(); var repeat = 0
        for (symbol in s) { when { symbol.isDigit() -> repeat = repeat * 10 + symbol.digitToInt(); symbol == '[' -> { counts.addLast(repeat); prefixes.addLast(current); current = StringBuilder(); repeat = 0 }; symbol == ']' -> { var times = counts.removeLast(); val expanded = prefixes.removeLast(); while (times-- > 0) expanded.append(current); current = expanded }; else -> current.append(symbol) } }
        return current.toString()
    }
}
