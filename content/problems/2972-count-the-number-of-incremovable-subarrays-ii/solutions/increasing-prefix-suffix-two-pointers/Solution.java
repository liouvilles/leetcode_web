class Solution {
    public long incremovableSubarrayCount(int[] nums){
        int n=nums.length,prefixEnd=0;
        while(prefixEnd+1<n&&nums[prefixEnd]<nums[prefixEnd+1])prefixEnd++;
        if(prefixEnd==n-1)return (long)n*(n+1)/2;
        long answer=prefixEnd+2L;
        for(int suffixStart=n-1;suffixStart>0&&(suffixStart==n-1||nums[suffixStart]<nums[suffixStart+1]);suffixStart--){
            while(prefixEnd>=0&&nums[prefixEnd]>=nums[suffixStart])prefixEnd--;
            answer+=prefixEnd+2L;
        }
        return answer;
    }
}
