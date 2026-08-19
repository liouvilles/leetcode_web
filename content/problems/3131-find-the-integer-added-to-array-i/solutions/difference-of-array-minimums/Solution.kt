class Solution {
    fun addedInteger(nums1:IntArray,nums2:IntArray):Int{
        return nums2.minOrNull()!!-nums1.minOrNull()!!
    }
}
