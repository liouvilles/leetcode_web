class Solution {
    public: int minDistance(string word1,string word2){
        vector<int> dp(word2.size()+1);
        for(int i=1;i<=(int)word1.size();++i){
            int diagonal=0;
            for(int j=1;j<=(int)word2.size();++j){
                int above=dp[j];
                dp[j]=word1[i-1]==word2[j-1]?diagonal+1:max(dp[j],dp[j-1]);
                diagonal=above;
            }
        }
        return word1.size()+word2.size()-2*dp.back();
    }
};
