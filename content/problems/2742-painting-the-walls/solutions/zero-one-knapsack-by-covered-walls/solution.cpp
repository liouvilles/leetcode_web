class Solution {
    public:int paintWalls(vector<int>& cost,vector<int>& time){
        int n=cost.size(),inf=1000000000;
        vector<int> dp(n+1,inf);
        dp[0]=0;
        for(int i=0;i<n;++i)for(int covered=n-1;covered>=0;--covered)if(dp[covered]<inf){
            int next=min(n,covered+time[i]+1);
            dp[next]=min(dp[next],dp[covered]+cost[i]);
        }
        return dp[n];
    }
};
