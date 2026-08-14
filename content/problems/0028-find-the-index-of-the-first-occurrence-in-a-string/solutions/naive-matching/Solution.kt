class Solution {
    fun strStr(haystack: String, needle: String): Int {
        for (start in 0..haystack.length - needle.length) {
            var index = 0
            while (index < needle.length && haystack[start + index] == needle[index]) index++
            if (index == needle.length) return start
        }
        return -1
    }
}
