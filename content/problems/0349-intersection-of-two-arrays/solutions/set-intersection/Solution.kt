class Solution {
    fun intersection(nums1:IntArray,nums2:IntArray):IntArray{
        val first=nums1.toHashSet();
        return nums2.filter{
            it in first
        }.distinct().sorted().toIntArray()
    }
}
