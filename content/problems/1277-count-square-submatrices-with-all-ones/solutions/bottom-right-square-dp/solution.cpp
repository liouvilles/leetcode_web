class Solution {
    public: int countSquares(vector<vector<int>>& matrix){
        int rows=matrix.size(),columns=matrix[0].size(),answer=0;
        vector<vector<int>> dp(rows+1,vector<int>(columns+1));
        for(int r=1;r<=rows;++r)for(int c=1;c<=columns;++c)if(matrix[r-1][c-1]){
            dp[r][c]=1+min({
                dp[r-1][c-1],dp[r-1][c],dp[r][c-1]
            });
            answer+=dp[r][c];
        }
        return answer;
    }
};
