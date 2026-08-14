class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val tails = IntArray(nums.size); var size = 0
        for (value in nums) { var left = 0; var right = size; while (left < right) { val middle = left + (right - left) / 2; if (tails[middle] < value) left = middle + 1 else right = middle }; tails[left] = value; if (left == size) size++ }
        return size
    }
}
