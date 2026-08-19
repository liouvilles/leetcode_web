class Solution {
    fun incremovableSubarrayCount(nums:IntArray):Int{
        val n=nums.size;
        var prefix=0;
        while(prefix+1<n&&nums[prefix]<nums[prefix+1])prefix++;
        if(prefix==n-1)return n*(n+1)/2;
        var answer=prefix+2;
        for(suffix in n-1 downTo 1){
            while(prefix>=0&&nums[prefix]>=nums[suffix])prefix--;
            answer+=prefix+2;
            if(nums[suffix-1]>=nums[suffix])break
        };
        return answer
    }
}
