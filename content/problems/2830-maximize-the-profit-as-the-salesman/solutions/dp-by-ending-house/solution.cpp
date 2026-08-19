class Solution {
    public:int maximizeTheProfit(int n,vector<vector<int>>& offers){
        sort(offers.begin(),offers.end(),[](auto& a,auto& b){
            return a[1]<b[1];
        });
        vector<int> dp(n+1);
        int index=0;
        for(int end=0;end<n;++end){
            dp[end+1]=max(dp[end+1],dp[end]);
            while(index<(int)offers.size()&&offers[index][1]==end){
                auto& offer=offers[index++];
                dp[end+1]=max(dp[end+1],dp[offer[0]]+offer[2]);
            }
        }
        return dp[n];
    }
};
