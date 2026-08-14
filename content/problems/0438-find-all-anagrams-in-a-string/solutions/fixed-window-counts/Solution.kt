class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()
        val target = IntArray(26); val window = IntArray(26); for (value in p) target[value - 'a']++
        val answer = ArrayList<Int>()
        for (right in s.indices) { window[s[right] - 'a']++; if (right >= p.length) window[s[right - p.length] - 'a']--; if (right >= p.length - 1 && target.contentEquals(window)) answer.add(right - p.length + 1) }
        return answer
    }
}
