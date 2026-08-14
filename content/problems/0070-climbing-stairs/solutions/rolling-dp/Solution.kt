class Solution {
    fun climbStairs(n: Int): Int {
        var previous = 1
        var current = 1
        for (step in 2..n) {
            val next = previous + current
            previous = current
            current = next
        }
        return current
    }
}
