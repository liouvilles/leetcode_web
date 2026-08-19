class Solution {
    fun minMoves(nums:IntArray,k:Int):Int{
        val adjusted=mutableListOf<Long>();
        for(i in nums.indices)if(nums[i]==1)adjusted.add(i.toLong()-adjusted.size);
        val prefix=LongArray(adjusted.size+1);
        for(i in adjusted.indices)prefix[i+1]=prefix[i]+adjusted[i];
        var answer=Long.MAX_VALUE;
        for(left in 0..adjusted.size-k){
            val right=left+k-1;
            val mid=(left+right)/2;
            val median=adjusted[mid];
            val cost=median*(mid-left)-(prefix[mid]-prefix[left])+(prefix[right+1]-prefix[mid+1])-median*(right-mid);
            answer=minOf(answer,cost)
        };
        return answer.toInt()
    }
}
