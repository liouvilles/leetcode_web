class Solution {
    public: int minCost(int n,vector<int>& cuts){
        vector<int> positions{
            0
        };
        positions.insert(positions.end(),cuts.begin(),cuts.end());
        positions.push_back(n);
        sort(positions.begin(),positions.end());
        int size=positions.size();
        vector<vector<int>> dp(size,vector<int>(size));
        for(int span=2;span<size;++span)for(int left=0;left+span<size;++left){
            int right=left+span;
            dp[left][right]=INT_MAX;
            for(int middle=left+1;middle<right;++middle)dp[left][right]=min(dp[left][right],positions[right]-positions[left]+dp[left][middle]+dp[middle][right]);
        }
        return dp[0][size-1];
    }
};
