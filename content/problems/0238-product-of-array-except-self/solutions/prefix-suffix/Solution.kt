class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size); answer[0] = 1
        for (index in 1 until nums.size) answer[index] = answer[index - 1] * nums[index - 1]
        var suffix = 1
        for (index in nums.lastIndex downTo 0) { answer[index] *= suffix; suffix *= nums[index] }
        return answer
    }
}
