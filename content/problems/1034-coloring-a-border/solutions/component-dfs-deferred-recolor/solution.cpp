class Solution {
    vector<vector<int>> directions{
        {
            1,0
        },{
            -1,0
        },{
            0,1
        },{
            0,-1
        }
    };
    void dfs(vector<vector<int>>& grid,int r,int c,int original,vector<vector<bool>>& visited,vector<pair<int,int>>& borders){
        visited[r][c]=true;
        bool border=false;
        for(auto& d:directions){
            int nr=r+d[0],nc=c+d[1];
            if(nr<0||nr==(int)grid.size()||nc<0||nc==(int)grid[0].size()||grid[nr][nc]!=original)border=true;
            else if(!visited[nr][nc])dfs(grid,nr,nc,original,visited,borders);
        }
        if(border)borders.push_back({
            r,c
        });
    }
    public:vector<vector<int>> colorBorder(vector<vector<int>>& grid,int row,int col,int color){
        vector<vector<bool>> visited(grid.size(),vector<bool>(grid[0].size()));
        vector<pair<int,int>> borders;
        dfs(grid,row,col,grid[row][col],visited,borders);
        for(auto cell:borders)grid[cell.first][cell.second]=color;
        return grid;
    }
};
