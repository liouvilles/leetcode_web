class Solution {
    public: int diagonalSum(vector<vector<int>>& mat){
        int n=mat.size(),answer=0;
        for(int row=0;row<n;++row)answer+=mat[row][row]+mat[row][n-1-row];
        if(n%2)answer-=mat[n/2][n/2];
        return answer;
    }
};
