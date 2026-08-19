class Solution {
    fun maxSubsequence(nums:IntArray,k:Int):IntArray=nums.withIndex().sortedByDescending{
        it.value
    }.take(k).sortedBy{
        it.index
    }.map{
        it.value
    }.toIntArray()
}
