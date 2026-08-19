class Solution {
    public:int minPathCost(vector<vector<int>>& grid,vector<vector<int>>& moveCost){
        int columns=grid[0].size();
        vector<int> dp=grid[0];
        for(int row=0;row+1<(int)grid.size();++row){
            vector<int> next(columns,INT_MAX);
            for(int column=0;column<columns;++column)for(int nc=0;nc<columns;++nc)next[nc]=min(next[nc],dp[column]+moveCost[grid[row][column]][nc]+grid[row+1][nc]);
            dp=move(next);
        }
        return *min_element(dp.begin(),dp.end());
    }
};
