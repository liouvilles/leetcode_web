class Solution {
    public int countSubMultisets(List<Integer> nums,int l,int r){
        final int MOD=1000000007;
        Map<Integer,Integer> count=new HashMap<>();
        for(int value:nums)count.put(value,count.getOrDefault(value,0)+1);
        int[] dp=new int[r+1];
        dp[0]=count.getOrDefault(0,0)+1;
        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            int value=entry.getKey(),copies=entry.getValue();
            if(value==0)continue;
            int[] next=new int[r+1];
            long removedDistance=(long)(copies+1)*value;
            for(int sum=0;sum<=r;sum++){
                long ways=dp[sum];
                if(sum>=value)ways+=next[sum-value];
                if(sum>=removedDistance)ways-=dp[(int)(sum-removedDistance)];
                ways%=MOD;
                if(ways<0)ways+=MOD;
                next[sum]=(int)ways;
            }
            dp=next;
        }
        long answer=0;
        for(int sum=l;sum<=r;sum++)answer+=dp[sum];
        return (int)(answer%MOD);
    }
}
