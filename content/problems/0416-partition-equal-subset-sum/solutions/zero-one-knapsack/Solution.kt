class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum(); if (sum % 2 != 0) return false
        val target = sum / 2; val possible = BooleanArray(target + 1); possible[0] = true
        for (value in nums) for (current in target downTo value) possible[current] = possible[current] || possible[current - value]
        return possible[target]
    }
}
