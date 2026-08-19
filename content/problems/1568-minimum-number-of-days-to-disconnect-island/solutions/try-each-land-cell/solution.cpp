class Solution {
    vector<vector<int>> grid;
    int rows,cols;
    void dfs(int row,int col,vector<vector<bool>>& seen){
        if(row<0||row>=rows||col<0||col>=cols||!grid[row][col]||seen[row][col])return;
        seen[row][col]=true;
        dfs(row+1,col,seen);
        dfs(row-1,col,seen);
        dfs(row,col+1,seen);
        dfs(row,col-1,seen);
    }
    int islands(){
        vector<vector<bool>> seen(rows,vector<bool>(cols));
        int count=0;
        for(int row=0;row<rows;++row)for(int col=0;col<cols;++col)if(grid[row][col]&&!seen[row][col]){
            ++count;
            dfs(row,col,seen);
        }
        return count;
    }
    public:int minDays(vector<vector<int>>& grid){
        this->grid=grid;
        rows=grid.size();
        cols=grid[0].size();
        if(islands()!=1)return 0;
        for(int row=0;row<rows;++row)for(int col=0;col<cols;++col)if(this->grid[row][col]){
            this->grid[row][col]=0;
            int count=islands();
            this->grid[row][col]=1;
            if(count!=1)return 1;
        }
        return 2;
    }
};
