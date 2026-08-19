class Solution {
    public: int findPaths(int m,int n,int maxMove,int startRow,int startColumn){
        const long long mod=1000000007;
        long long answer=0;
        vector<vector<long long>> dp(m,vector<long long>(n));
        dp[startRow][startColumn]=1;
        int directions[4][2]={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        while(maxMove--){
            vector<vector<long long>> next(m,vector<long long>(n));
            for(int row=0;row<m;++row)for(int column=0;column<n;++column)for(auto& direction:directions){
                int r=row+direction[0],c=column+direction[1];
                if(r<0||r>=m||c<0||c>=n)answer=(answer+dp[row][column])%mod;
                else next[r][c]=(next[r][c]+dp[row][column])%mod;
            }
            dp.swap(next);
        }
        return answer;
    }
};
