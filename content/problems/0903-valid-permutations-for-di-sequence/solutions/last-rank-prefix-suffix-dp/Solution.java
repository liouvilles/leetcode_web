class Solution {
    public int numPermsDISequence(String s){
        long mod=1000000007L;
        long[] dp={
            1
        };
        for(char relation:s.toCharArray()){
            long[] next=new long[dp.length+1];
            if(relation=='I')for(int j=1;j<next.length;j++)next[j]=(next[j-1]+dp[j-1])%mod;
            else for(int j=dp.length-1;j>=0;j--)next[j]=(next[j+1]+dp[j])%mod;
            dp=next;
        }
        long answer=0;
        for(long value:dp)answer=(answer+value)%mod;
        return(int)answer;
    }
}
