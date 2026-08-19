class Solution {
    public: int numMusicPlaylists(int n,int goal,int k){
        const long long mod=1000000007;
        vector<vector<long long>> dp(goal+1,vector<long long>(n+1));
        dp[0][0]=1;
        for(int length=0;length<goal;++length)for(int used=0;used<=n;++used){
            if(used<n)dp[length+1][used+1]=(dp[length+1][used+1]+dp[length][used]*(n-used))%mod;
            if(used>k)dp[length+1][used]=(dp[length+1][used]+dp[length][used]*(used-k))%mod;
        }
        return dp[goal][n];
    }
};
