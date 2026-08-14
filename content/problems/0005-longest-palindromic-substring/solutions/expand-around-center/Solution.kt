class Solution {
    fun longestPalindrome(s: String): String {
        var bestLeft = 0
        var bestRight = 0
        for (center in s.indices) {
            val length = maxOf(expand(s, center, center), expand(s, center, center + 1))
            if (length > bestRight - bestLeft + 1) {
                bestLeft = center - (length - 1) / 2
                bestRight = center + length / 2
            }
        }
        return s.substring(bestLeft, bestRight + 1)
    }

    private fun expand(s: String, startLeft: Int, startRight: Int): Int {
        var left = startLeft
        var right = startRight
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        return right - left - 1
    }
}
