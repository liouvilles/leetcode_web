class Solution {
    static const long long MOD=1000000007;
    long long power(long long base,long long exponent){
        long long result=1;
        while(exponent){
            if(exponent&1)result=result*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return result;
    }
    public: int countGoodNumbers(long long n){
        return power(5,(n+1)/2)*power(4,n/2)%MOD;
    }
};
