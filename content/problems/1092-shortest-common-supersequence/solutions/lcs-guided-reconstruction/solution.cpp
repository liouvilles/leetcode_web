class Solution {
    public: string shortestCommonSupersequence(string str1,string str2){
        int m=str1.size(),n=str2.size();
        vector<vector<int>> dp(m+1,vector<int>(n+1));
        for(int i=m-1;i>=0;--i)for(int j=n-1;j>=0;--j)dp[i][j]=str1[i]==str2[j]?dp[i+1][j+1]+1:max(dp[i+1][j],dp[i][j+1]);
        string answer;
        int i=0,j=0;
        while(i<m&&j<n)if(str1[i]==str2[j]){
            answer+=str1[i++];
            ++j;
        }else if(dp[i+1][j]>=dp[i][j+1])answer+=str1[i++];
        else answer+=str2[j++];
        return answer+str1.substr(i)+str2.substr(j);
    }
};
