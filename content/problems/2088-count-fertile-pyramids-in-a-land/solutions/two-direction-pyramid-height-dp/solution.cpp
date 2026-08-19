class Solution {
    int countPyramidsOne(vector<vector<int>>& grid){
        int rows=grid.size(),cols=grid[0].size(),answer=0;
        vector<vector<int>> height(rows,vector<int>(cols));
        for(int row=rows-1;row>=0;--row)for(int col=0;col<cols;++col)if(grid[row][col]){
            height[row][col]=1;
            if(row+1<rows&&col&&col+1<cols)height[row][col]+=min({
                height[row+1][col-1],height[row+1][col],height[row+1][col+1]
            });
            answer+=height[row][col]-1;
        }
        return answer;
    }
    public: int countPyramids(vector<vector<int>>& grid){
        int answer=countPyramidsOne(grid);
        reverse(grid.begin(),grid.end());
        return answer+countPyramidsOne(grid);
    }
};
