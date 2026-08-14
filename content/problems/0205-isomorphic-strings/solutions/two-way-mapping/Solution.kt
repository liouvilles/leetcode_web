class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val forward = IntArray(256) { -1 }; val backward = IntArray(256) { -1 }
        for (index in s.indices) { val first = s[index].code; val second = t[index].code; if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first } else if (forward[first] != second || backward[second] != first) return false }
        return true
    }
}
