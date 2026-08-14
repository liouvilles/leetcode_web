class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val answer = ArrayList<List<Int>>()
        for (first in 0 until nums.size - 2) {
            if (first > 0 && nums[first] == nums[first - 1]) continue
            if (nums[first] > 0) break
            var left = first + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[first] + nums[left] + nums[right]
                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        answer.add(listOf(nums[first], nums[left], nums[right]))
                        val leftValue = nums[left]
                        val rightValue = nums[right]
                        while (left < right && nums[left] == leftValue) left++
                        while (left < right && nums[right] == rightValue) right--
                    }
                }
            }
        }
        return answer
    }
}
