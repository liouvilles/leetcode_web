class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val first = strs[0]
        for (index in first.indices) for (item in 1 until strs.size) if (index == strs[item].length || strs[item][index] != first[index]) return first.substring(0, index)
        return first
    }
}
