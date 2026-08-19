class Solution {
    public: int minFallingPathSum(vector<vector<int>>& matrix){
        vector<int> dp=matrix[0];
        for(int row=1;row<(int)matrix.size();++row){
            vector<int> next(matrix.size());
            for(int col=0;col<(int)matrix.size();++col){
                int best=dp[col];
                if(col)best=min(best,dp[col-1]);
                if(col+1<(int)matrix.size())best=min(best,dp[col+1]);
                next[col]=matrix[row][col]+best;
            }
            dp.swap(next);
        }
        return *min_element(dp.begin(),dp.end());
    }
};
