class Solution {
    fun subarraysWithKDistinct(nums:IntArray,k:Int):Int=atMost(nums,k)-atMost(nums,k-1);
    private fun atMost(nums:IntArray,limit:Int):Int{
        val frequency=mutableMapOf<Int,Int>();
        var left=0;
        var distinct=0;
        var count=0;
        for(right in nums.indices){
            if((frequency[nums[right]]?:0)==0)distinct++;
            frequency[nums[right]]=(frequency[nums[right]]?:0)+1;
            while(distinct>limit){
                val value=nums[left++];
                frequency[value]=frequency[value]!!-1;
                if(frequency[value]==0)distinct--
            };
            count+=right-left+1
        };
        return count
    }
}
