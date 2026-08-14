class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val target = IntArray(26); val window = IntArray(26)
        for (index in s1.indices) { target[s1[index] - 'a']++; window[s2[index] - 'a']++ }
        for (left in 0..s2.length - s1.length) { if (target.contentEquals(window)) return true; val next = left + s1.length; if (next < s2.length) { window[s2[left] - 'a']--; window[s2[next] - 'a']++ } }
        return false
    }
}
