class Solution {
    public: double knightProbability(int n,int k,int row,int column){
        vector<vector<double>> dp(n,vector<double>(n));
        dp[row][column]=1;
        int moves[8][2]={
            {
                1,2
            },{
                1,-2
            },{
                -1,2
            },{
                -1,-2
            },{
                2,1
            },{
                2,-1
            },{
                -2,1
            },{
                -2,-1
            }
        };
        while(k--){
            vector<vector<double>> next(n,vector<double>(n));
            for(int r=0;r<n;++r)for(int c=0;c<n;++c)for(auto& move:moves){
                int nr=r+move[0],nc=c+move[1];
                if(nr>=0&&nr<n&&nc>=0&&nc<n)next[nr][nc]+=dp[r][c]/8;
            }
            dp.swap(next);
        }
        double answer=0;
        for(auto& line:dp)answer=accumulate(line.begin(),line.end(),answer);
        return answer;
    }
};
