class Solution {
    public: int countServers(vector<vector<int>>& grid){
        int rows=grid.size(),columns=grid[0].size();
        vector<int> rowCount(rows),columnCount(columns);
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)if(grid[r][c]){
            ++rowCount[r];
            ++columnCount[c];
        }
        int answer=0;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)answer+=grid[r][c]&&(rowCount[r]>1||columnCount[c]>1);
        return answer;
    }
};
