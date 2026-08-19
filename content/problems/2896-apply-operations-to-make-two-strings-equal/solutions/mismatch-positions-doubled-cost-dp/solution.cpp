class Solution {
    public:int minOperations(string s1,string s2,int x){
        vector<int> positions;
        for(int i=0;i<(int)s1.size();++i)if(s1[i]!=s2[i])positions.push_back(i);
        int m=positions.size();
        if(m&1)return -1;
        if(!m)return 0;
        vector<int> dp(m+1);
        dp[1]=x;
        for(int i=2;i<=m;++i)dp[i]=min(dp[i-1]+x,dp[i-2]+2*(positions[i-1]-positions[i-2]));
        return dp[m]/2;
    }
};
