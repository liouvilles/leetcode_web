class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val values = nums.toHashSet()
        var best = 0
        for (value in values) {
            if (value - 1 in values) continue
            var length = 1
            while (value + length in values) length++
            best = maxOf(best, length)
        }
        return best
    }
}
