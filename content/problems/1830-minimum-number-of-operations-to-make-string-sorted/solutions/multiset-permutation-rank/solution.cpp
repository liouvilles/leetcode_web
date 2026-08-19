class Solution {
    static const long long MOD=1000000007;
    long long power(long long base,long long exponent){
        long long answer=1;
        while(exponent){
            if(exponent&1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    public:int makeStringSorted(string text){
        int n=text.size();
        vector<long long> factorial(n+1),inverse(n+1);
        factorial[0]=1;
        for(int i=1;i<=n;++i)factorial[i]=factorial[i-1]*i%MOD;
        inverse[n]=power(factorial[n],MOD-2);
        for(int i=n;i>0;--i)inverse[i-1]=inverse[i]*i%MOD;
        array<int,26> count{
        };
        for(char c:text)++count[c-'a'];
        long long answer=0;
        for(int position=0;position<n;++position){
            long long base=factorial[n-position-1];
            for(int value:count)base=base*inverse[value]%MOD;
            int letter=text[position]-'a',smaller=accumulate(count.begin(),count.begin()+letter,0);
            answer=(answer+base*smaller)%MOD;
            --count[letter];
        }
        return answer;
    }
};
