class Solution {
    public int numSubseq(int[] nums,int target){
        Arrays.sort(nums);
        int n=nums.length,mod=1_000_000_007;
        long[] powers=new long[n];
        powers[0]=1;
        for(int i=1;i<n;i++)powers[i]=powers[i-1]*2%mod;
        int left=0,right=n-1;
        long answer=0;
        while(left<=right)if(nums[left]+nums[right]<=target){
            answer=(answer+powers[right-left])%mod;
            left++;
        }else right--;
        return (int)answer;
    }
}
