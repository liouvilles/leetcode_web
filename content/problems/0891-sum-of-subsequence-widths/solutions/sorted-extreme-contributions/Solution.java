class Solution {
    public int sumSubseqWidths(int[] nums){
        Arrays.sort(nums);
        long mod=1000000007L,answer=0;
        long[] powers=new long[nums.length];
        powers[0]=1;
        for(int i=1;i<nums.length;i++)powers[i]=powers[i-1]*2%mod;
        for(int i=0;i<nums.length;i++)answer=(answer+nums[i]*(powers[i]-powers[nums.length-1-i]))%mod;
        return(int)((answer+mod)%mod);
    }
}
