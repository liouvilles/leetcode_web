class Solution {
    public: int numberWays(vector<vector<int>>& hats){
        int people=hats.size();
        const long long mod=1000000007;
        vector<vector<int>> wearers(41);
        for(int person=0;person<people;++person)for(int hat:hats[person])wearers[hat].push_back(person);
        vector<long long> dp(1<<people);
        dp[0]=1;
        for(int hat=1;hat<=40;++hat){
            auto next=dp;
            for(int mask=0;mask<(int)dp.size();++mask)if(dp[mask])for(int person:wearers[hat])if(!(mask&(1<<person))){
                int newMask=mask|1<<person;
                next[newMask]=(next[newMask]+dp[mask])%mod;
            }
            dp=move(next);
        }
        return dp.back();
    }
};
