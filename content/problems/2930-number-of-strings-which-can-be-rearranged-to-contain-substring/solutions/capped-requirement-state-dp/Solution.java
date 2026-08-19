class Solution {
    public int stringCount(int n){
        final long MOD=1000000007;
        long[][][] dp=new long[2][3][2];
        dp[0][0][0]=1;
        for(int length=0;length<n;length++){
            long[][][] next=new long[2][3][2];
            for(int l=0;l<2;l++)for(int e=0;e<3;e++)for(int t=0;t<2;t++){
                long ways=dp[l][e][t];
                next[l][e][t]=(next[l][e][t]+23*ways)%MOD;
                next[1][e][t]=(next[1][e][t]+ways)%MOD;
                next[l][Math.min(2,e+1)][t]=(next[l][Math.min(2,e+1)][t]+ways)%MOD;
                next[l][e][1]=(next[l][e][1]+ways)%MOD;
            }
            dp=next;
        }
        return (int)dp[1][2][1];
    }
}
