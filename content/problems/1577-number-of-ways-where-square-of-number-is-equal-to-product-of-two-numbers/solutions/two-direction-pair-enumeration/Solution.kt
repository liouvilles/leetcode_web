class Solution {
    private fun count(singles:IntArray,pairs:IntArray):Int{
        var answer=0;
        for(value in singles){
            val square=value.toLong()*value;
            for(left in pairs.indices)for(right in left+1 until pairs.size)if(pairs[left].toLong()*pairs[right]==square)answer++
        };
        return answer
    };
    fun numTriplets(nums1:IntArray,nums2:IntArray):Int=count(nums1,nums2)+count(nums2,nums1)
}
