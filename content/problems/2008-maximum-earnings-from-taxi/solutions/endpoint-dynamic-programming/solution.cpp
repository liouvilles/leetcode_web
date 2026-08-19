class Solution {
    public: long long maxTaxiEarnings(int n,vector<vector<int>>& rides){
        sort(rides.begin(),rides.end(),[](auto& a,auto& b){
            return a[1]<b[1];
        });
        vector<long long> dp(n+1);
        int index=0;
        for(int position=1;position<=n;++position){
            dp[position]=dp[position-1];
            while(index<(int)rides.size()&&rides[index][1]==position){
                auto& ride=rides[index++];
                dp[position]=max(dp[position],dp[ride[0]]+ride[1]-ride[0]+ride[2]);
            }
        }
        return dp[n];
    }
};
