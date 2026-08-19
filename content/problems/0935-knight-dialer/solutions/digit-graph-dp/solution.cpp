class Solution {
    public: int knightDialer(int n){
        vector<vector<int>> next={
            {
                4,6
            },{
                6,8
            },{
                7,9
            },{
                4,8
            },{
                0,3,9
            },{
            },{
                0,1,7
            },{
                2,6
            },{
                1,3
            },{
                2,4
            }
        };
        const long long mod=1000000007;
        vector<long long> dp(10,1);
        for(int length=1;length<n;++length){
            vector<long long> updated(10);
            for(int from=0;from<10;++from)for(int to:next[from])updated[to]=(updated[to]+dp[from])%mod;
            dp.swap(updated);
        }
        return accumulate(dp.begin(),dp.end(),0LL)%mod;
    }
};
