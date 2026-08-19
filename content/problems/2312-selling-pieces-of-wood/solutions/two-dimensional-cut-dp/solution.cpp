class Solution {
    public:long long sellingWood(int m,int n,vector<vector<int>>& prices){
        vector dp(m+1,vector<long long>(n+1));
        for(auto& price:prices)dp[price[0]][price[1]]=max(dp[price[0]][price[1]],(long long)price[2]);
        for(int h=1;h<=m;++h)for(int w=1;w<=n;++w){
            for(int cut=1;cut<h;++cut)dp[h][w]=max(dp[h][w],dp[cut][w]+dp[h-cut][w]);
            for(int cut=1;cut<w;++cut)dp[h][w]=max(dp[h][w],dp[h][cut]+dp[h][w-cut]);
        }
        return dp[m][n];
    }
};
