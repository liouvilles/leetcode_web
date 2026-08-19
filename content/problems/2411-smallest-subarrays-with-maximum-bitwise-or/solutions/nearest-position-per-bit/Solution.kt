class Solution {
    fun smallestSubarrays(nums:IntArray):IntArray{
        val last=IntArray(32){
            -1
        };
        val answer=IntArray(nums.size);
        for(i in nums.size-1 downTo 0){
            for(bit in 0 until 32)if(nums[i] and (1 shl bit)!=0)last[bit]=i;
            var farthest=i;
            for(position in last)farthest=maxOf(farthest,position);
            answer[i]=farthest-i+1
        };
        return answer
    }
}
