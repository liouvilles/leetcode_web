class Solution {
    private fun countAtMost(nums:IntArray,limit:Int):Long{
        val frequency=IntArray(100001);
        var left=0;
        var distinct=0;
        var count=0L;
        for(right in nums.indices){
            if(frequency[nums[right]]++==0)distinct++;
            while(distinct>limit){
                if(--frequency[nums[left++]]==0)distinct--
            };
            count+=right-left+1
        };
        return count
    }
    fun medianOfUniquenessArray(nums:IntArray):Int{
        val total=nums.size.toLong()*(nums.size+1)/2;
        val target=(total+1)/2;
        var low=1;
        var high=nums.size;
        while(low<high){
            val middle=(low+high)/2;
            if(countAtMost(nums,middle)>=target)high=middle else low=middle+1
        };
        return low
    }
}
