class Solution {
    public: int longestPalindromeSubseq(string s){
        vector<int> dp(s.size());
        for(int i=s.size()-1;i>=0;--i){
            dp[i]=1;
            int previous=0;
            for(int j=i+1;j<(int)s.size();++j){
                int old=dp[j];
                dp[j]=s[i]==s[j]?previous+2:max(dp[j],dp[j-1]);
                previous=old;
            }
        }
        return dp.back();
    }
};
