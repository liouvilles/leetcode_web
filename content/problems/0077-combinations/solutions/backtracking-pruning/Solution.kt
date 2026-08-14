class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>()
        fun backtrack(start: Int) { if (path.size == k) { answer.add(path.toList()); return }; val limit = n - (k - path.size) + 1; for (value in start..limit) { path.add(value); backtrack(value + 1); path.removeAt(path.lastIndex) } }
        backtrack(1); return answer
    }
}
