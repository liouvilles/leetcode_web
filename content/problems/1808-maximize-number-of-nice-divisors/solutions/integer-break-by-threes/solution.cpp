class Solution {
    static const long long MOD=1000000007;
    long long power(long long base,int exponent){
        long long answer=1;
        while(exponent){
            if(exponent&1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    public:int maxNiceDivisors(int primeFactors){
        if(primeFactors<=3)return primeFactors;
        int quotient=primeFactors/3,remainder=primeFactors%3;
        return remainder==0?power(3,quotient):remainder==1?power(3,quotient-1)*4%MOD:power(3,quotient)*2%MOD;
    }
};
