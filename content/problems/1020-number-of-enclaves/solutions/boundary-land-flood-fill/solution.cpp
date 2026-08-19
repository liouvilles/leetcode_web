class Solution {
    void flood(vector<vector<int>>& grid,int r,int c){
        if(r<0||r==(int)grid.size()||c<0||c==(int)grid[0].size()||grid[r][c]!=1)return;
        grid[r][c]=0;
        flood(grid,r+1,c);
        flood(grid,r-1,c);
        flood(grid,r,c+1);
        flood(grid,r,c-1);
    }
    public:int numEnclaves(vector<vector<int>>& grid){
        int rows=grid.size(),columns=grid[0].size();
        for(int r=0;r<rows;++r){
            flood(grid,r,0);
            flood(grid,r,columns-1);
        }
        for(int c=0;c<columns;++c){
            flood(grid,0,c);
            flood(grid,rows-1,c);
        }
        int answer=0;
        for(auto& row:grid)answer+=accumulate(row.begin(),row.end(),0);
        return answer;
    }
};
