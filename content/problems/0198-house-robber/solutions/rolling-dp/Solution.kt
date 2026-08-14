class Solution {
    fun rob(nums: IntArray): Int {
        var beforePrevious = 0
        var previous = 0
        for (money in nums) {
            val current = maxOf(previous, beforePrevious + money)
            beforePrevious = previous
            previous = current
        }
        return previous
    }
}
