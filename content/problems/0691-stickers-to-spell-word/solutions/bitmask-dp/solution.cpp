class Solution {
    public: int minStickers(vector<string>& stickers,string target){
        int full=(1<<target.size())-1;
        vector<int> dp(full+1,INT_MAX);
        dp[0]=0;
        for(int mask=0;mask<=full;++mask){
            if(dp[mask]==INT_MAX)continue;
            for(string& sticker:stickers){
                int counts[26]{
                };
                for(char c:sticker)++counts[c-'a'];
                int next=mask;
                for(int i=0;i<(int)target.size();++i)if(!(next&(1<<i))&&counts[target[i]-'a']>0){
                    --counts[target[i]-'a'];
                    next|=1<<i;
                }
                if(next!=mask)dp[next]=min(dp[next],dp[mask]+1);
            }
        }
        return dp[full]==INT_MAX?-1:dp[full];
    }
};
