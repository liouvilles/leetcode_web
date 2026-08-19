class Solution {
    public: int largest1BorderedSquare(vector<vector<int>>& grid){
        int rows=grid.size(),columns=grid[0].size(),best=0;
        vector<vector<int>> left(rows,vector<int>(columns)),up=left;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)if(grid[r][c]){
            left[r][c]=1+(c?left[r][c-1]:0);
            up[r][c]=1+(r?up[r-1][c]:0);
            for(int side=min(left[r][c],up[r][c]);side>best;--side)if(left[r-side+1][c]>=side&&up[r][c-side+1]>=side){
                best=side;
                break;
            }
        }
        return best*best;
    }
};
