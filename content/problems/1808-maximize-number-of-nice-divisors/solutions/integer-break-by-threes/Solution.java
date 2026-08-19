class Solution {
    static final long MOD=1_000_000_007L;
    private long power(long base,int exponent){
        long answer=1;
        while(exponent>0){
            if((exponent&1)==1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    public int maxNiceDivisors(int primeFactors){
        if(primeFactors<=3)return primeFactors;
        int quotient=primeFactors/3,remainder=primeFactors%3;
        long answer=remainder==0?power(3,quotient):remainder==1?power(3,quotient-1)*4%MOD:power(3,quotient)*2%MOD;
        return (int)answer;
    }
}
