class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val answer = mutableListOf<String>(); val parts = mutableListOf<String>()
        fun backtrack(index: Int) { val remainingParts = 4 - parts.size; val remainingChars = s.length - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return; if (parts.size == 4) { if (index == s.length) answer.add(parts.joinToString(".")); return }; var value = 0; for (end in index until minOf(index + 3, s.length)) { if (end > index && s[index] == '0') break; value = value * 10 + (s[end] - '0'); if (value > 255) break; parts.add(s.substring(index, end + 1)); backtrack(end + 1); parts.removeAt(parts.lastIndex) } }
        backtrack(0); return answer
    }
}
