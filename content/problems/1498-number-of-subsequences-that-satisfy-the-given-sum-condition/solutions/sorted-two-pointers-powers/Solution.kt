class Solution {
    fun numSubseq(nums:IntArray,target:Int):Int{
        nums.sort();
        val mod=1_000_000_007L;
        val powers=LongArray(nums.size);
        powers[0]=1;
        for(i in 1 until nums.size)powers[i]=powers[i-1]*2%mod;
        var left=0;
        var right=nums.lastIndex;
        var answer=0L;
        while(left<=right)if(nums[left]+nums[right]<=target){
            answer=(answer+powers[right-left])%mod;
            left++
        }else right--;
        return answer.toInt()
    }
}
