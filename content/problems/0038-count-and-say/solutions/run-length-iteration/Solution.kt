class Solution {
    fun countAndSay(n: Int): String {
        var answer = "1"
        repeat(n - 1) { val next = StringBuilder(); var start = 0; while (start < answer.length) { var end = start + 1; while (end < answer.length && answer[end] == answer[start]) end++; next.append(end - start).append(answer[start]); start = end }; answer = next.toString() }
        return answer
    }
}
