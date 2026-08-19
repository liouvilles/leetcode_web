class Solution {
    private fun lowerBound(values:LongArray,leftValue:Int,rightValue:Int,target:Long):Int{
        var left=leftValue;
        var right=rightValue;
        while(left<right){
            val mid=(left+right) ushr 1;
            if(values[mid]<target)left=mid+1 else right=mid
        };
        return left
    };
    fun waysToSplit(nums:IntArray):Int{
        val mod=1_000_000_007L;
        val n=nums.size;
        val prefix=LongArray(n+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i];
        var answer=0L;
        for(first in 1..n-2){
            val low=lowerBound(prefix,first+1,n,2*prefix[first]);
            val high=lowerBound(prefix,first+1,n,(prefix[n]+prefix[first])/2+1);
            if(high>low)answer=(answer+high-low)%mod
        };
        return answer.toInt()
    }
}
