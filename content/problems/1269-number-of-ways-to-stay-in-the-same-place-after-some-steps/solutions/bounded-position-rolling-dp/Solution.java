class Solution {
    public int numWays(int steps,int arrLen){
        int limit=Math.min(arrLen,steps/2+1),mod=1000000007;
        long[] dp=new long[limit];
        dp[0]=1;
        for(int step=0;step<steps;step++){
            long[] next=new long[limit];
            for(int position=0;position<limit;position++){
                next[position]=(next[position]+dp[position])%mod;
                if(position>0)next[position-1]=(next[position-1]+dp[position])%mod;
                if(position+1<limit)next[position+1]=(next[position+1]+dp[position])%mod;
            }
            dp=next;
        }
        return (int)dp[0];
    }
}
