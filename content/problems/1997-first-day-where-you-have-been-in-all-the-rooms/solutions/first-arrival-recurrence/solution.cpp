class Solution {
    public: int firstDayBeenInAllRooms(vector<int>& nextVisit){
        const long long MOD=1000000007;
        vector<long long> dp(nextVisit.size());
        for(int i=1;i<(int)dp.size();++i)dp[i]=(2*dp[i-1]-dp[nextVisit[i-1]]+2+MOD)%MOD;
        return dp.back();
    }
};
