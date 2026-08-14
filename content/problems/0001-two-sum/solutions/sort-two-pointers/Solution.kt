class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairs = nums.mapIndexed { index, value -> intArrayOf(value, index) }
            .sortedBy { it[0] }
        var left = 0
        var right = pairs.lastIndex
        while (left < right) {
            val sum = pairs[left][0] + pairs[right][0]
            when {
                sum == target -> return intArrayOf(pairs[left][1], pairs[right][1])
                sum < target -> left++
                else -> right--
            }
        }
        return intArrayOf()
    }
}
