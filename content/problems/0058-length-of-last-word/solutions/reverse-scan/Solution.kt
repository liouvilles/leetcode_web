class Solution {
    fun lengthOfLastWord(s: String): Int {
        var index = s.lastIndex; while (index >= 0 && s[index] == ' ') index--
        var length = 0; while (index >= 0 && s[index] != ' ') { length++; index-- }
        return length
    }
}
