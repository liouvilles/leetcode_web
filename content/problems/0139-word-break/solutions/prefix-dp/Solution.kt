class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val words = wordDict.toHashSet()
        val possible = BooleanArray(s.length + 1)
        possible[0] = true
        for (end in 1..s.length) {
            for (start in 0 until end) {
                if (possible[start] && s.substring(start, end) in words) {
                    possible[end] = true
                    break
                }
            }
        }
        return possible[s.length]
    }
}
