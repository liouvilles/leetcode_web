class Solution {
    fun maxSum(nums:List<Int>,m:Int,k:Int):Long{
        val frequency=HashMap<Int,Int>();
        var sum=0L;
        var answer=0L;
        for(right in nums.indices){
            val value=nums[right];
            sum+=value;
            frequency[value]=(frequency[value]?:0)+1;
            if(right>=k){
                val removed=nums[right-k];
                sum-=removed;
                val count=frequency[removed]!!-1;
                if(count==0)frequency.remove(removed) else frequency[removed]=count
            };
            if(right>=k-1&&frequency.size>=m)answer=maxOf(answer,sum)
        };
        return answer
    }
}
