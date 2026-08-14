class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val counts = HashMap<Int, Int>(); counts[0] = 1; var prefix = 0; var answer = 0
        for (value in nums) { prefix += value; answer += counts[prefix - k] ?: 0; counts[prefix] = (counts[prefix] ?: 0) + 1 }
        return answer
    }
}
