class Solution {
    public: int projectionArea(vector<vector<int>>& grid){
        int n=grid.size(),top=0;
        vector<int> rows(n),columns(n);
        for(int r=0;r<n;++r)for(int c=0;c<n;++c){
            top+=grid[r][c]>0;
            rows[r]=max(rows[r],grid[r][c]);
            columns[c]=max(columns[c],grid[r][c]);
        }
        return top+accumulate(rows.begin(),rows.end(),0)+accumulate(columns.begin(),columns.end(),0);
    }
};
