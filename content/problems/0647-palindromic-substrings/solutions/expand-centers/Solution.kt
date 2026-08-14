class Solution {
    fun countSubstrings(s: String): Int { var answer = 0; for (center in s.indices) answer += expand(s, center, center) + expand(s, center, center + 1); return answer }
    private fun expand(s: String, startLeft: Int, startRight: Int): Int { var left = startLeft; var right = startRight; var count = 0; while (left >= 0 && right < s.length && s[left] == s[right]) { count++; left--; right++ }; return count }
}
