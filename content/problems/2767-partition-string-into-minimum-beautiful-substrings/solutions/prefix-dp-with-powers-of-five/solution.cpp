class Solution {
    public:int minimumBeautifulSubstrings(string s){
        unordered_set<long long> powers;
        long long limit=1LL<<s.size();
        for(long long value=1;value<limit;value*=5)powers.insert(value);
        const int INF=1000000;
        vector<int> dp(s.size()+1,INF);
        dp[0]=0;
        for(int start=0;start<(int)s.size();++start)if(dp[start]<INF&&s[start]!='0'){
            long long value=0;
            for(int end=start;end<(int)s.size();++end){
                value=value*2+s[end]-'0';
                if(powers.count(value))dp[end+1]=min(dp[end+1],dp[start]+1);
            }
        }
        return dp.back()==INF?-1:dp.back();
    }
};
