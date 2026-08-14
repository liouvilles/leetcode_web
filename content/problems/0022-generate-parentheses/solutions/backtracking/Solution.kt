class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val answer = ArrayList<String>()
        build(n, 0, 0, StringBuilder(), answer)
        return answer
    }

    private fun build(n: Int, open: Int, close: Int, path: StringBuilder, answer: MutableList<String>) {
        if (path.length == 2 * n) {
            answer.add(path.toString())
            return
        }
        if (open < n) {
            path.append('(')
            build(n, open + 1, close, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
        if (close < open) {
            path.append(')')
            build(n, open, close + 1, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
    }
}
