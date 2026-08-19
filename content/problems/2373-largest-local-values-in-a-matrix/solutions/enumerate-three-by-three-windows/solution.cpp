class Solution {
    public:vector<vector<int>> largestLocal(vector<vector<int>>& grid){
        int n=grid.size();
        vector answer(n-2,vector<int>(n-2));
        for(int row=0;row<n-2;++row)for(int column=0;column<n-2;++column)for(int r=row;r<row+3;++r)for(int c=column;c<column+3;++c)answer[row][column]=max(answer[row][column],grid[r][c]);
        return answer;
    }
};
