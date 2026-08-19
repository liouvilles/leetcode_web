class Solution {
    vector<array<int,2>> extras,zeros;
    vector<int> memo;
    int dfs(int mask){
        int index=__builtin_popcount(mask);
        if(index==(int)extras.size())return 0;
        if(memo[mask]!=-1)return memo[mask];
        int answer=1000000;
        for(int target=0;target<(int)zeros.size();++target)if(!(mask&(1<<target))){
            int distance=abs(extras[index][0]-zeros[target][0])+abs(extras[index][1]-zeros[target][1]);
            answer=min(answer,distance+dfs(mask|1<<target));
        }
        return memo[mask]=answer;
    }
    public:int minimumMoves(vector<vector<int>>& grid){
        for(int row=0;row<3;++row)for(int col=0;col<3;++col){
            if(!grid[row][col])zeros.push_back({
                row,col
            });
            for(int count=1;count<grid[row][col];++count)extras.push_back({
                row,col
            });
        }
        memo.assign(1<<zeros.size(),-1);
        return dfs(0);
    }
};
