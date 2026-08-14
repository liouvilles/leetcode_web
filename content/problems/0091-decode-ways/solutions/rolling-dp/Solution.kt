class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0
        var beforePrevious = 1; var previous = 1
        for (index in 1 until s.length) { var current = if (s[index] == '0') 0 else previous; val pair = (s[index - 1] - '0') * 10 + (s[index] - '0'); if (pair in 10..26) current += beforePrevious; beforePrevious = previous; previous = current }
        return previous
    }
}
