class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort(); var best = nums[0] + nums[1] + nums[2]
        for (first in 0 until nums.size - 2) { var left = first + 1; var right = nums.lastIndex; while (left < right) { val sum = nums[first] + nums[left] + nums[right]; if (kotlin.math.abs(sum.toLong() - target) < kotlin.math.abs(best.toLong() - target)) best = sum; if (sum == target) return target; if (sum < target) left++ else right-- } }
        return best
    }
}
