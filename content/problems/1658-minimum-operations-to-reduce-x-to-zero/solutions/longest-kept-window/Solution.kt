class Solution {
    fun minOperations(nums:IntArray,x:Int):Int{
        val target=nums.sum()-x;
        if(target<0)return -1;
        if(target==0)return nums.size;
        var left=0;
        var sum=0;
        var longest=-1;
        for(right in nums.indices){
            sum+=nums[right];
            while(sum>target)sum-=nums[left++];
            if(sum==target)longest=maxOf(longest,right-left+1)
        };
        return if(longest<0)-1 else nums.size-longest
    }
}
