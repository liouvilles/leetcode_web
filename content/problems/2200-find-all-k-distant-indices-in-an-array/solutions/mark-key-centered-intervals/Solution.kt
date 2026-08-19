class Solution {
    fun findKDistantIndices(nums:IntArray,key:Int,k:Int):List<Int>{
        val nearby=BooleanArray(nums.size);
        for(j in nums.indices)if(nums[j]==key)for(i in maxOf(0,j-k)..minOf(nums.lastIndex,j+k))nearby[i]=true;
        return nums.indices.filter{
            nearby[it]
        }
    }
}
