class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val last = HashMap<Char, Int>()
        var left = 0
        var best = 0
        for (right in s.indices) {
            val c = s[right]
            left = maxOf(left, (last[c] ?: -1) + 1)
            last[c] = right
            best = maxOf(best, right - left + 1)
        }
        return best
    }
}
