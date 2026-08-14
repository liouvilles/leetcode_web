class Solution {
    fun convertToTitle(input: Int): String { var columnNumber = input; val answer = StringBuilder(); while (columnNumber > 0) { columnNumber--; answer.append(('A'.code + columnNumber % 26).toChar()); columnNumber /= 26 }; return answer.reverse().toString() }
}
