class Solution {
    fun countGood(nums:IntArray,k:Int):Long{
        val frequency=HashMap<Int,Int>();
        var pairs=0L;
        var answer=0L;
        var left=0;
        for(right in nums.indices){
            val value=nums[right];
            val count=frequency[value]?:0;
            pairs+=count;
            frequency[value]=count+1;
            while(pairs>=k){
                answer+=nums.size-right;
                val removed=nums[left++];
                val remaining=frequency[removed]!!-1;
                frequency[removed]=remaining;
                pairs-=remaining
            }
        };
        return answer
    }
}
