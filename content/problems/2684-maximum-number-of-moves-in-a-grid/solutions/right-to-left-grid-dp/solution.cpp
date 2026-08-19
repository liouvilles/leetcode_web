class Solution {
    public:int maxMoves(vector<vector<int>>& grid){
        int rows=grid.size(),cols=grid[0].size();
        vector dp(rows,vector<int>(cols));
        for(int col=cols-2;col>=0;--col)for(int row=0;row<rows;++row)for(int nextRow=max(0,row-1);nextRow<=min(rows-1,row+1);++nextRow)if(grid[nextRow][col+1]>grid[row][col])dp[row][col]=max(dp[row][col],1+dp[nextRow][col+1]);
        int answer=0;
        for(int row=0;row<rows;++row)answer=max(answer,dp[row][0]);
        return answer;
    }
};
