class Solution {
    vector<vector<int>> *first,*second;
    bool dfs(int row,int col){
        if(row<0||row==(int)second->size()||col<0||col==(int)(*second)[0].size()||!(*second)[row][col])return true;
        (*second)[row][col]=0;
        bool valid=(*first)[row][col];
        valid=dfs(row+1,col)&valid;
        valid=dfs(row-1,col)&valid;
        valid=dfs(row,col+1)&valid;
        valid=dfs(row,col-1)&valid;
        return valid;
    }
    public: int countSubIslands(vector<vector<int>>& grid1,vector<vector<int>>& grid2){
        first=&grid1;
        second=&grid2;
        int answer=0;
        for(int row=0;row<(int)grid2.size();++row)for(int col=0;col<(int)grid2[0].size();++col)if(grid2[row][col]&&dfs(row,col))++answer;
        return answer;
    }
};
