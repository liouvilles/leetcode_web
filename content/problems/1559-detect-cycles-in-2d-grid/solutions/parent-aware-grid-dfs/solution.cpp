class Solution {
    vector<vector<char>> grid;
    vector<vector<bool>> seen;
    int rows,cols;
    bool dfs(int row,int col,int parentRow,int parentCol){
        seen[row][col]=true;
        int directions[4][2]={
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
        for(auto& direction:directions){
            int nr=row+direction[0],nc=col+direction[1];
            if(nr<0||nr>=rows||nc<0||nc>=cols||grid[nr][nc]!=grid[row][col])continue;
            if(!seen[nr][nc]){
                if(dfs(nr,nc,row,col))return true;
            }else if(nr!=parentRow||nc!=parentCol)return true;
        }
        return false;
    }
    public:bool containsCycle(vector<vector<char>>& grid){
        this->grid=grid;
        rows=grid.size();
        cols=grid[0].size();
        seen.assign(rows,vector<bool>(cols));
        for(int row=0;row<rows;++row)for(int col=0;col<cols;++col)if(!seen[row][col]&&dfs(row,col,-1,-1))return true;
        return false;
    }
};
