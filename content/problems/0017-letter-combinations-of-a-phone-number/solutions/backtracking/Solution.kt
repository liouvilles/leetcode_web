class Solution {
    private val letters = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val answer = ArrayList<String>()
        build(digits, 0, StringBuilder(), answer)
        return answer
    }

    private fun build(digits: String, index: Int, path: StringBuilder, answer: MutableList<String>) {
        if (index == digits.length) { answer.add(path.toString()); return }
        for (letter in letters[digits[index].digitToInt()]) {
            path.append(letter)
            build(digits, index + 1, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
    }
}
