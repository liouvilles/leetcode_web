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
    public:int idealArrays(int n,int maxValue){
        long long combination[15]={
            1
        };
        for(int e=1;e<15;++e)combination[e]=combination[e-1]*(n-1LL+e)%MOD*power(e,MOD-2)%MOD;
        long long answer=0;
        for(int value=1;value<=maxValue;++value){
            int remaining=value;
            long long ways=1;
            for(int factor=2;factor*factor<=remaining;++factor)if(remaining%factor==0){
                int exponent=0;
                while(remaining%factor==0){
                    remaining/=factor;
                    ++exponent;
                }
                ways=ways*combination[exponent]%MOD;
            }
            if(remaining>1)ways=ways*combination[1]%MOD;
            answer=(answer+ways)%MOD;
        }
        return answer;
    }
};
