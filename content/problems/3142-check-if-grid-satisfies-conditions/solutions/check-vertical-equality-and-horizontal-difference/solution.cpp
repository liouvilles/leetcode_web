class Solution {
    public:bool satisfiesConditions(vector<vector<int>>& grid){
        for(int row=0;row<(int)grid.size();++row)for(int col=0;col<(int)grid[0].size();++col){
            if(row&&grid[row][col]!=grid[row-1][col])return false;
            if(col&&grid[row][col]==grid[row][col-1])return false;
        }
        return true;
    }
};
