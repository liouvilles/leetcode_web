class Solution {
    int powerAtMost(int base,int exponent,int limit){
        long long value=1;
        while(exponent--){
            value*=base;
            if(value>limit)return limit+1;
        }
        return value;
    }
    public:int numberOfWays(int n,int x){
        const int MOD=1000000007;
        vector<int> dp(n+1);
        dp[0]=1;
        for(int base=1;;++base){
            int power=powerAtMost(base,x,n);
            if(power>n)break;
            for(int sum=n;sum>=power;--sum){
                dp[sum]+=dp[sum-power];
                if(dp[sum]>=MOD)dp[sum]-=MOD;
            }
        }
        return dp[n];
    }
};
