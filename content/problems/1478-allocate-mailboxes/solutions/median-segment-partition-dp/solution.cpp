class Solution {
    public: int minDistance(vector<int>& houses,int k){
        sort(houses.begin(),houses.end());
        int n=houses.size();
        vector<vector<int>> segment(n,vector<int>(n));
        for(int left=0;left<n;++left)for(int right=left;right<n;++right){
            int median=houses[(left+right)/2];
            for(int i=left;i<=right;++i)segment[left][right]+=abs(houses[i]-median);
        }
        const int inf=1000000000;
        vector<vector<int>> dp(k+1,vector<int>(n+1,inf));
        dp[0][0]=0;
        for(int boxes=1;boxes<=k;++boxes)for(int count=1;count<=n;++count)for(int previous=0;previous<count;++previous)if(dp[boxes-1][previous]<inf)dp[boxes][count]=min(dp[boxes][count],dp[boxes-1][previous]+segment[previous][count-1]);
        return dp[k][n];
    }
};
