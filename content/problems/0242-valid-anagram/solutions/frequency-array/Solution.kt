class Solution {
    fun isAnagram(first: String, second: String): Boolean {
        if (first.length != second.length) return false
        val counts = IntArray(26)
        for (index in first.indices) { counts[first[index] - 'a']++; counts[second[index] - 'a']-- }
        return counts.all { it == 0 }
    }
}
