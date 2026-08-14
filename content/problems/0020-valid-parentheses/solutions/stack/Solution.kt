class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false
        val stack = java.util.ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(' -> stack.push(')')
                '[' -> stack.push(']')
                '{' -> stack.push('}')
                else -> if (stack.isEmpty() || stack.pop() != c) return false
            }
        }
        return stack.isEmpty()
    }
}
