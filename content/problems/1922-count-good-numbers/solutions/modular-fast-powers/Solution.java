class Solution {
    static final long MOD=1_000_000_007;
    private long power(long base,long exponent){
        long result=1;
        while(exponent>0){
            if((exponent&1)==1)result=result*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return result;
    }
    public int countGoodNumbers(long n){
        return (int)(power(5,(n+1)/2)*power(4,n/2)%MOD);
    }
}
