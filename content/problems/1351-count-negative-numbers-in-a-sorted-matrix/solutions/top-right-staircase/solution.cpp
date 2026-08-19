class Solution {
    public: int countNegatives(vector<vector<int>>& grid){
        int rows=grid.size(),row=0,column=grid[0].size()-1,answer=0;
        while(row<rows&&column>=0)if(grid[row][column]<0){
            answer+=rows-row;
            --column;
        }else ++row;
        return answer;
    }
};
