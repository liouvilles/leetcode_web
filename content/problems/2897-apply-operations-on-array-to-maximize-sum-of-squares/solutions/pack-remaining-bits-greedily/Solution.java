class Solution {
    public int maxSum(List<Integer> nums,int k){
        final long MOD=1000000007L;
        int[] count=new int[31];
        for(int value:nums)for(int bit=0;bit<31;bit++)if((value&(1<<bit))!=0)count[bit]++;
        long answer=0;
        for(int round=0;round<k;round++){
            int value=0;
            for(int bit=0;bit<31;bit++)if(count[bit]>0){
                value|=1<<bit;
                count[bit]--;
            }
            answer=(answer+(long)value*value)%MOD;
        }
        return (int)answer;
    }
}
