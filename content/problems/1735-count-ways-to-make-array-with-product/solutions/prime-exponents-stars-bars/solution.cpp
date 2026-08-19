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
    long long combination(int n,int exponent){
        long long answer=1;
        for(int i=1;i<=exponent;++i)answer=answer*(n+i-1)%MOD*power(i,MOD-2)%MOD;
        return answer;
    }
    public:vector<int> waysToFillArray(vector<vector<int>>& queries){
        vector<int> answer;
        for(auto query:queries){
            int n=query[0],value=query[1];
            long long ways=1;
            for(int prime=2;prime*prime<=value;++prime)if(value%prime==0){
                int exponent=0;
                while(value%prime==0){
                    value/=prime;
                    ++exponent;
                }
                ways=ways*combination(n,exponent)%MOD;
            }
            if(value>1)ways=ways*n%MOD;
            answer.push_back(ways);
        }
        return answer;
    }
};
