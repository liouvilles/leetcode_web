class Solution {
    public:int monkeyMove(int n){
        const long long mod=1'000'000'007;
        long long base=2,result=1;
        while(n){
            if(n&1)result=result*base%mod;
            base=base*base%mod;
            n>>=1;
        }
        return (result-2+mod)%mod;
    }
};
