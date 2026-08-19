class Solution {
    vector<vector<int>>* grid;
    int rows,columns;
    int dfs(int r,int c,int remaining){
        if((*grid)[r][c]==2)return remaining==1;
        int saved=(*grid)[r][c],paths=0;
        (*grid)[r][c]=-1;
        int directions[4][2]={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        for(auto& d:directions){
            int nr=r+d[0],nc=c+d[1];
            if(nr>=0&&nr<rows&&nc>=0&&nc<columns&&(*grid)[nr][nc]!=-1)paths+=dfs(nr,nc,remaining-1);
        }
        (*grid)[r][c]=saved;
        return paths;
    }
    public:int uniquePathsIII(vector<vector<int>>& input){
        grid=&input;
        rows=input.size();
        columns=input[0].size();
        int sr=0,sc=0,walkable=0;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)if(input[r][c]!=-1){
            ++walkable;
            if(input[r][c]==1){
                sr=r;
                sc=c;
            }
        }
        return dfs(sr,sc,walkable);
    }
};
