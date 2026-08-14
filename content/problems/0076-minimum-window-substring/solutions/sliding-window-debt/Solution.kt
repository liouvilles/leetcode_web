class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""
        val need = IntArray(128)
        for (char in t) need[char.code]++
        var missing = t.length
        var left = 0
        var bestStart = 0
        var bestLength = Int.MAX_VALUE
        for (right in s.indices) {
            val added = s[right].code
            if (need[added] > 0) missing--
            need[added]--
            while (missing == 0) {
                val length = right - left + 1
                if (length < bestLength) { bestLength = length; bestStart = left }
                val removed = s[left++].code
                need[removed]++
                if (need[removed] > 0) missing++
            }
        }
        return if (bestLength == Int.MAX_VALUE) "" else s.substring(bestStart, bestStart + bestLength)
    }
}
