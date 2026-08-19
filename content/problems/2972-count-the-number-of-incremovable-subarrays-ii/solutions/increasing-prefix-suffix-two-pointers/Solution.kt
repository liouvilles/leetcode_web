class Solution {
    fun incremovableSubarrayCount(nums:IntArray):Long{
        val n=nums.size;
        var prefixEnd=0;
        while(prefixEnd+1<n&&nums[prefixEnd]<nums[prefixEnd+1])prefixEnd++;
        if(prefixEnd==n-1)return n.toLong()*(n+1)/2;
        var answer=prefixEnd+2L;
        for(suffixStart in n-1 downTo 1){
            if(suffixStart<n-1&&nums[suffixStart]>=nums[suffixStart+1])break;
            while(prefixEnd>=0&&nums[prefixEnd]>=nums[suffixStart])prefixEnd--;
            answer+=prefixEnd+2L
        };
        return answer
    }
}
