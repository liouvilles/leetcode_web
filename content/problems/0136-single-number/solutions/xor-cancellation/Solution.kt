class Solution {
    fun singleNumber(nums: IntArray): Int {
        var answer = 0
        for (value in nums) answer = answer xor value
        return answer
    }
}
