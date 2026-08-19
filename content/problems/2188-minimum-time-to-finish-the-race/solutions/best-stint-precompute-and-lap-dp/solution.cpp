class Solution {
    public:int minimumFinishTime(vector<vector<int>>& tires,int changeTime,int numLaps){
        const long long infinity=LLONG_MAX/4;
        vector<long long> best(numLaps+1,infinity);
        int fastest=INT_MAX;
        for(auto& tire:tires)fastest=min(fastest,tire[0]);
        for(auto& tire:tires){
            long long lap=tire[0],total=0;
            for(int run=1;run<=numLaps&&lap<=fastest+changeTime;++run){
                total+=lap;
                best[run]=min(best[run],total);
                if(lap>infinity/tire[1])break;
                lap*=tire[1];
            }
        }
        vector<long long> dp(numLaps+1,infinity);
        dp[0]=-changeTime;
        for(int laps=1;laps<=numLaps;++laps)for(int run=1;run<=laps&&best[run]<infinity;++run)dp[laps]=min(dp[laps],dp[laps-run]+changeTime+best[run]);
        return dp[numLaps];
    }
};
