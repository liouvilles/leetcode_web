class Solution {
    public: int numberOfArrays(string text,int k){
        int n=text.size(),mod=1000000007;
        vector<int> dp(n+1);
        dp[n]=1;
        for(int i=n-1;i>=0;--i){
            if(text[i]=='0')continue;
            long long value=0;
            for(int j=i;j<n;++j){
                value=value*10+text[j]-'0';
                if(value>k)break;
                dp[i]=(dp[i]+dp[j+1])%mod;
            }
        }
        return dp[0];
    }
};
