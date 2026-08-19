class Solution {
    public: int mergeStones(vector<int>& stones,int k){
        int n=stones.size();
        if((n-1)%(k-1))return -1;
        vector<int> prefix(n+1);
        for(int i=0;i<n;++i)prefix[i+1]=prefix[i]+stones[i];
        vector<vector<int>> dp(n,vector<int>(n));
        for(int length=2;length<=n;++length)for(int left=0;left+length<=n;++left){
            int right=left+length-1;
            dp[left][right]=INT_MAX/2;
            for(int middle=left;middle<right;middle+=k-1)dp[left][right]=min(dp[left][right],dp[left][middle]+dp[middle+1][right]);
            if((length-1)%(k-1)==0)dp[left][right]+=prefix[right+1]-prefix[left];
        }
        return dp[0][n-1];
    }
};
