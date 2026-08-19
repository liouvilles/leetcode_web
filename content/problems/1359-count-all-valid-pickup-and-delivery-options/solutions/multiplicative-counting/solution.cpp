class Solution {
    public: int countOrders(int n){
        const long long mod=1000000007;
        long long answer=1;
        for(long long i=1;i<=n;++i)answer=answer*i%mod*(2*i-1)%mod;
        return answer;
    }
};
