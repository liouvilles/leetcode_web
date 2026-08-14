class Solution {
    fun compareVersion(version1: String, version2: String): Int { val first = version1.split('.'); val second = version2.split('.'); for (index in 0 until maxOf(first.size, second.size)) { val left = if (index < first.size) first[index].toLong() else 0L; val right = if (index < second.size) second[index].toLong() else 0L; if (left < right) return -1; if (left > right) return 1 }; return 0 }
}
