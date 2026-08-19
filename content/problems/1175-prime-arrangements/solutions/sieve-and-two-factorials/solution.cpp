class Solution {
    public: int numPrimeArrangements(int n){
        vector<bool> prime(n+1,true);
        prime[0]=false;
        if(n>=1)prime[1]=false;
        for(int value=2;value*value<=n;++value)if(prime[value])for(int multiple=value*value;multiple<=n;multiple+=value)prime[multiple]=false;
        int count=count_if(prime.begin(),prime.end(),[](bool value){
            return value;
        });
        long long answer=1,mod=1000000007;
        for(int value=2;value<=count;++value)answer=answer*value%mod;
        for(int value=2;value<=n-count;++value)answer=answer*value%mod;
        return answer;
    }
};
