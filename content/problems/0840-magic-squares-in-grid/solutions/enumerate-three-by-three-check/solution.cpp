class Solution {
    bool magic(vector<vector<int>>& grid,int r,int c){
        bool seen[10]{
        };
        for(int i=0;i<3;++i)for(int j=0;j<3;++j){
            int value=grid[r+i][c+j];
            if(value<1||value>9||seen[value])return false;
            seen[value]=true;
        }
        for(int i=0;i<3;++i)if(grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2]!=15||grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i]!=15)return false;
        return grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2]==15&&grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]==15;
    }
    public:int numMagicSquaresInside(vector<vector<int>>& grid){
        int answer=0;
        for(int r=0;r+2<(int)grid.size();++r)for(int c=0;c+2<(int)grid[0].size();++c)answer+=magic(grid,r,c);
        return answer;
    }
};
