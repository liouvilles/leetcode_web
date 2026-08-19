class Solution {
    vector<vector<int>> grid;
    vector<vector<vector<int>>> memo;
    int dfs(int row,int first,int second){
        if(first<0||second<0||first>=(int)grid[0].size()||second>=(int)grid[0].size())return -1000000;
        if(row==(int)grid.size())return 0;
        int& cached=memo[row][first][second];
        if(cached!=-1)return cached;
        int current=grid[row][first]+(first==second?0:grid[row][second]),best=0;
        for(int moveFirst=-1;moveFirst<=1;++moveFirst)for(int moveSecond=-1;moveSecond<=1;++moveSecond)best=max(best,dfs(row+1,first+moveFirst,second+moveSecond));
        return cached=current+best;
    }
    public:int cherryPickup(vector<vector<int>>& grid){
        this->grid=grid;
        int rows=grid.size(),cols=grid[0].size();
        memo.assign(rows,vector<vector<int>>(cols,vector<int>(cols,-1)));
        return dfs(0,0,cols-1);
    }
};
