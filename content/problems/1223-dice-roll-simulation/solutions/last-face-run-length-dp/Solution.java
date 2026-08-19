class Solution {
    public int dieSimulator(int n,int[] rollMax){
        long mod=1000000007L;
        long[][] dp=new long[6][16];
        for(int face=0;face<6;face++)dp[face][1]=1;
        for(int length=2;length<=n;length++){
            long[][] next=new long[6][16];
            for(int face=0;face<6;face++)for(int run=1;run<=rollMax[face];run++)if(dp[face][run]>0)for(int nextFace=0;nextFace<6;nextFace++)if(nextFace==face){
                if(run<rollMax[face])next[face][run+1]=(next[face][run+1]+dp[face][run])%mod;
            }else next[nextFace][1]=(next[nextFace][1]+dp[face][run])%mod;
            dp=next;
        }
        long answer=0;
        for(long[] face:dp)for(long count:face)answer=(answer+count)%mod;
        return (int)answer;
    }
}
