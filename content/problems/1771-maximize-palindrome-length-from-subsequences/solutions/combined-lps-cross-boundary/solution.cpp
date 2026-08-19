class Solution {
    public: int longestPalindrome(string word1,string word2){
        string text=word1+word2;
        int n=text.size();
        vector<vector<int>> dp(n,vector<int>(n));
        for(int i=n-1;i>=0;--i){
            dp[i][i]=1;
            for(int j=i+1;j<n;++j)dp[i][j]=text[i]==text[j]?2+(i+1<=j-1?dp[i+1][j-1]:0):max(dp[i+1][j],dp[i][j-1]);
        }
        int answer=0;
        for(int i=0;i<(int)word1.size();++i)for(int j=word1.size();j<n;++j)if(text[i]==text[j])answer=max(answer,2+(i+1<=j-1?dp[i+1][j-1]:0));
        return answer;
    }
};
