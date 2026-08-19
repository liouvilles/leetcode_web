class Solution {
    public int numberOfGoodSubarraySplits(int[] nums){
        final long MOD=1000000007;
        long answer=1;
        int previous=-1;
        for(int i=0;i<nums.length;i++)if(nums[i]==1){
            if(previous!=-1)answer=answer*(i-previous)%MOD;
            previous=i;
        }
        return previous==-1?0:(int)answer;
    }
}
