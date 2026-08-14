class Solution {
    fun reverseWords(s: String): String = s.trim().split(Regex("\\s+")).asReversed().joinToString(" ")
}
