class Solution {
    private static final int MOD=1_000_000_007;
    private static final int[] PRIMES={
        2,3,5,7,11,13,17,19,23,29
    };
    private int maskOf(int value){
        int mask=0;
        for(int i=0;i<PRIMES.length;i++){
            int prime=PRIMES[i];
            if(value%(prime*prime)==0)return -1;
            if(value%prime==0)mask|=1<<i;
        }
        return mask;
    }
    public int squareFreeSubsets(int[] nums){
        int[] dp=new int[1<<PRIMES.length];
        dp[0]=1;
        for(int value:nums){
            int valueMask=maskOf(value);
            if(valueMask<0)continue;
            int[] next=dp.clone();
            for(int state=0;state<dp.length;state++){
                if((state&valueMask)!=0)continue;
                int target=state|valueMask;
                next[target]=(int)(((long)next[target]+dp[state])%MOD);
            }
            dp=next;
        }
        long answer=0;
        for(int count:dp)answer=(answer+count)%MOD;
        return (int)((answer-1+MOD)%MOD);
    }
}
