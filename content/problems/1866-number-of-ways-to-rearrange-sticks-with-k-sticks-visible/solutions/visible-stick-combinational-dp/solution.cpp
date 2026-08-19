class Solution {
    public: int rearrangeSticks(int n,int k){
        const long long MOD=1000000007;
        vector<vector<long long>> dp(n+1,vector<long long>(k+1));
        dp[0][0]=1;
        for(int length=1;length<=n;++length)for(int visible=1;visible<=min(length,k);++visible)dp[length][visible]=(dp[length-1][visible-1]+(length-1)*dp[length-1][visible])%MOD;
        return dp[n][k];
    }
};
