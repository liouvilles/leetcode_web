class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]; var fast = nums[nums[0]]
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]] }
        var finder = 0
        while (finder != slow) { finder = nums[finder]; slow = nums[slow] }
        return finder
    }
}
