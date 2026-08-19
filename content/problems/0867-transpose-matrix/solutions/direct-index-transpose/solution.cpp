class Solution {
    public: vector<vector<int>> transpose(vector<vector<int>>& matrix){
        int rows=matrix.size(),columns=matrix[0].size();
        vector<vector<int>> answer(columns,vector<int>(rows));
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)answer[c][r]=matrix[r][c];
        return answer;
    }
};
