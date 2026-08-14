class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentEnd = 0
        var farthest = 0
        for (index in 0 until nums.lastIndex) { farthest = maxOf(farthest, index + nums[index]); if (index == currentEnd) { jumps++; currentEnd = farthest } }
        return jumps
    }
}
