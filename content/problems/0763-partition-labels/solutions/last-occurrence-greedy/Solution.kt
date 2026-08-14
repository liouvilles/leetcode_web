class Solution {
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26); for (index in s.indices) last[s[index] - 'a'] = index
        val answer = ArrayList<Int>(); var start = 0; var end = 0
        for (index in s.indices) { end = maxOf(end, last[s[index] - 'a']); if (index == end) { answer.add(end - start + 1); start = index + 1 } }
        return answer
    }
}
