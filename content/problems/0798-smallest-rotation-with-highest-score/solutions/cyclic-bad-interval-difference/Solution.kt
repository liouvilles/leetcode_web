class Solution {
    fun bestRotation(nums:IntArray):Int{
        val n=nums.size;
        val change=IntArray(n);
        for(i in nums.indices)change[(i-nums[i]+1+n)%n]--;
        var best=0;
        for(k in 1 until n){
            change[k]+=change[k-1]+1;
            if(change[k]>change[best])best=k
        };
        return best
    }
}
