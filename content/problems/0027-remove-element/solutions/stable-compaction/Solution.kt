class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        var write = 0
        for (item in nums) if (item != value) nums[write++] = item
        return write
    }
}
