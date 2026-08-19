class Solution {
    public: int numWays(vector<string>& words,string target){
        const long long MOD=1000000007;
        int length=words[0].size();
        vector<array<int,26>> count(length);
        for(auto& word:words)for(int column=0;column<length;++column)++count[column][word[column]-'a'];
        vector<long long> dp(target.size()+1);
        dp[0]=1;
        for(int column=0;column<length;++column)for(int formed=min(column,(int)target.size()-1);formed>=0;--formed)dp[formed+1]=(dp[formed+1]+dp[formed]*count[column][target[formed]-'a'])%MOD;
        return dp[target.size()];
    }
};
