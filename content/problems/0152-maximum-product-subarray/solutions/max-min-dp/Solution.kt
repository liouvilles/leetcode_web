class Solution {
    fun maxProduct(nums: IntArray): Int {
        var currentMax = nums[0]
        var currentMin = nums[0]
        var answer = nums[0]
        for (index in 1 until nums.size) {
            val value = nums[index]
            val previousMax = currentMax
            currentMax = maxOf(value, previousMax * value, currentMin * value)
            currentMin = minOf(value, previousMax * value, currentMin * value)
            answer = maxOf(answer, currentMax)
        }
        return answer
    }
}
