class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            seen[complement]?.let { return intArrayOf(it, i) }
            seen[nums[i]] = i
        }
        return intArrayOf()
    }
}
