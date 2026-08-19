class Solution {
    public int checkRecord(int n){
        long mod=1000000007L;
        long[][] dp=new long[2][3];
        dp[0][0]=1;
        while(n-->0){
            long[][] next=new long[2][3];
            for(int a=0;a<2;a++)for(int l=0;l<3;l++){
                long value=dp[a][l];
                next[a][0]=(next[a][0]+value)%mod;
                if(a==0)next[1][0]=(next[1][0]+value)%mod;
                if(l<2)next[a][l+1]=(next[a][l+1]+value)%mod;
            }
            dp=next;
        }
        long answer=0;
        for(long[] row:dp)for(long value:row)answer=(answer+value)%mod;
        return(int)answer;
    }
}
