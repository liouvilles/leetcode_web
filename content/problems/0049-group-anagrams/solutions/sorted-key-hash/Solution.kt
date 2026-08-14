class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = linkedMapOf<String, MutableList<String>>()
        for (value in strs) {
            val chars = value.toCharArray()
            chars.sort()
            val key = chars.concatToString()
            groups.getOrPut(key) { ArrayList() }.add(value)
        }
        return groups.values.map { it.toList() }
    }
}
