class Solution {
    public: int minSessions(vector<int>& tasks,int sessionTime){
        int total=1<<tasks.size();
        vector<pair<int,int>> dp(total,{
            100,0
        });
        dp[0]={
            1,0
        };
        for(int mask=0;mask<total;++mask)for(int task=0;task<(int)tasks.size();++task)if(!(mask&(1<<task))){
            auto candidate=dp[mask];
            candidate.second+=tasks[task];
            if(candidate.second>sessionTime){
                ++candidate.first;
                candidate.second=tasks[task];
            }
            dp[mask|1<<task]=min(dp[mask|1<<task],candidate);
        }
        return dp.back().first;
    }
};
