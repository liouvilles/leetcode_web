class Solution {
    public: int matrixScore(vector<vector<int>>& grid){
        int rows=grid.size(),columns=grid[0].size(),answer=0;
        for(int c=0;c<columns;++c){
            int ones=0;
            for(int r=0;r<rows;++r)ones+=(grid[r][c]^grid[r][0])==0;
            ones=max(ones,rows-ones);
            answer+=ones*(1<<(columns-1-c));
        }
        return answer;
    }
};
