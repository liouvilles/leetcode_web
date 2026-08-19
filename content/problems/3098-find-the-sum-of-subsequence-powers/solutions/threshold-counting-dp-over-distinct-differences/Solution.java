class Solution {
    private static final long MOD=1000000007L;
    private long countAtLeast(int[] nums,int k,int difference){
        int n=nums.length;
        long[] previous=new long[n];
        Arrays.fill(previous,1);
        for(int length=2;length<=k;length++){
            long[] prefix=new long[n],current=new long[n];
            long sum=0;
            for(int index=0;index<n;index++){sum=(sum+previous[index])%MOD;prefix[index]=sum;}
            int pointer=-1;
            for(int index=0;index<n;index++){
                while(pointer+1<index&&(long)nums[index]-nums[pointer+1]>=difference)pointer++;
                if(pointer>=0)current[index]=prefix[pointer];
            }
            previous=current;
        }
        long result=0;
        for(long count:previous)result=(result+count)%MOD;
        return result;
    }
    public int sumOfPowers(int[] nums,int k){
        Arrays.sort(nums);
        TreeSet<Integer> set=new TreeSet<>();
        for(int left=0;left<nums.length;left++)for(int right=left+1;right<nums.length;right++)if(nums[right]>nums[left])set.add(nums[right]-nums[left]);
        int[] differences=new int[set.size()];
        int write=0;
        for(int difference:set)differences[write++]=difference;
        long[] counts=new long[differences.length];
        for(int index=0;index<differences.length;index++)counts[index]=countAtLeast(nums,k,differences[index]);
        long answer=0;
        for(int index=0;index<differences.length;index++){
            long next=index+1<differences.length?counts[index+1]:0;
            long exact=(counts[index]-next+MOD)%MOD;
            answer=(answer+(differences[index]%MOD)*exact)%MOD;
        }
        return (int)answer;
    }
}
