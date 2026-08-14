class Solution {
    fun titleToNumber(columnTitle: String): Int { var answer = 0; for (value in columnTitle) answer = answer * 26 + (value - 'A') + 1; return answer }
}
