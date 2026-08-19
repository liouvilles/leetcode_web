class Solution {
    public int countOrders(int n){
        long answer=1,mod=1_000_000_007L;
        for(long i=1;i<=n;i++)answer=answer*i%mod*(2*i-1)%mod;
        return (int)answer;
    }
}
