class Solution {
    public:int minExtraChar(string s,vector<string>& dictionary){
        unordered_set<string> words(dictionary.begin(),dictionary.end());
        vector<int> dp(s.size()+1);
        for(int end=1;end<=(int)s.size();++end){
            dp[end]=dp[end-1]+1;
            for(int start=0;start<end;++start)if(words.count(s.substr(start,end-start)))dp[end]=min(dp[end],dp[start]);
        }
        return dp[s.size()];
    }
};
