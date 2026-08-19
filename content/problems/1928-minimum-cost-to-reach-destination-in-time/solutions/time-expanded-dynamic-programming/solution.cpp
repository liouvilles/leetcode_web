class Solution {
    public: int minCost(int maxTime,vector<vector<int>>& edges,vector<int>& passingFees){
        const int INF=1000000000;
        int n=passingFees.size();
        vector<vector<int>> dp(maxTime+1,vector<int>(n,INF));
        dp[0][0]=passingFees[0];
        for(int time=0;time<=maxTime;++time)for(auto& edge:edges){
            int next=time+edge[2];
            if(next>maxTime)continue;
            if(dp[time][edge[0]]<INF)dp[next][edge[1]]=min(dp[next][edge[1]],dp[time][edge[0]]+passingFees[edge[1]]);
            if(dp[time][edge[1]]<INF)dp[next][edge[0]]=min(dp[next][edge[0]],dp[time][edge[1]]+passingFees[edge[0]]);
        }
        int answer=INF;
        for(int time=0;time<=maxTime;++time)answer=min(answer,dp[time][n-1]);
        return answer==INF?-1:answer;
    }
};
