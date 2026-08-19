class Solution {
    fun distance(nums:IntArray):LongArray{
        val totalCount=HashMap<Int,Int>();
        val totalSum=HashMap<Int,Long>();
        for(i in nums.indices){
            val value=nums[i];
            totalCount[value]=totalCount.getOrDefault(value,0)+1;
            totalSum[value]=totalSum.getOrDefault(value,0)+i
        };
        val leftCount=HashMap<Int,Int>();
        val leftSum=HashMap<Int,Long>();
        val answer=LongArray(nums.size);
        for(i in nums.indices){
            val value=nums[i];
            val leftNumber=leftCount.getOrDefault(value,0);
            val leftPositions=leftSum.getOrDefault(value,0);
            val rightNumber=totalCount[value]!!-leftNumber-1;
            val rightPositions=totalSum[value]!!-leftPositions-i;
            answer[i]=i.toLong()*leftNumber-leftPositions+rightPositions-i.toLong()*rightNumber;
            leftCount[value]=leftNumber+1;
            leftSum[value]=leftPositions+i
        };
        return answer
    }
}
