class Solution {
    public: int minInsertions(string s){
        string reversed=s;
        reverse(reversed.begin(),reversed.end());
        int n=s.size();
        vector<int> dp(n+1);
        for(int i=1;i<=n;++i){
            vector<int> next(n+1);
            for(int j=1;j<=n;++j)next[j]=s[i-1]==reversed[j-1]?dp[j-1]+1:max(dp[j],next[j-1]);
            dp.swap(next);
        }
        return n-dp[n];
    }
};
