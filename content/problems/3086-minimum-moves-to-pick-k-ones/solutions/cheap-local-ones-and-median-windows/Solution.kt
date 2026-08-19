class Solution {
    fun minimumMoves(nums:IntArray,k:Int,maxChanges:Int):Long{
        val ones=ArrayList<Int>();
        var run=0;
        var longest=0;
        for(index in nums.indices){
            if(nums[index]==1){
                ones.add(index);
                run++;
                longest=maxOf(longest,run)
            }else run=0
        };
        val cheap=minOf(k,3,longest);
        if(cheap+maxChanges>=k)return maxOf(0,cheap-1)+2L*(k-cheap);
        val required=k-maxChanges;
        val prefix=LongArray(ones.size+1);
        for(index in ones.indices)prefix[index+1]=prefix[index]+ones[index];
        var best=Long.MAX_VALUE;
        for(left in 0..ones.size-required){
            val right=left+required-1;
            val middle=left+required/2;
            val median=ones[middle].toLong();
            val leftCost=median*(middle-left)-(prefix[middle]-prefix[left]);
            val rightCost=prefix[right+1]-prefix[middle+1]-median*(right-middle);
            best=minOf(best,leftCost+rightCost)
        };
        return best+2L*maxChanges
    }
}
