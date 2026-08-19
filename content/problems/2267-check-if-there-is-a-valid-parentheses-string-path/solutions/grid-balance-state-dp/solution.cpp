class Solution {
    public:bool hasValidPath(vector<vector<char>>& grid){
        int rows=grid.size(),columns=grid[0].size(),length=rows+columns-1;
        if(length%2||grid[0][0]!='('||grid[rows-1][columns-1]!=')')return false;
        vector reachable(rows,vector(columns,vector<bool>(length+2)));
        reachable[0][0][1]=true;
        int directions[3]={
            1,0,1
        };
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)for(int balance=0;balance<=length;++balance)if(reachable[r][c][balance])for(int d=0;d<2;++d){
            int nr=r+directions[d],nc=c+directions[d+1];
            if(nr>=rows||nc>=columns)continue;
            int next=balance+(grid[nr][nc]=='('?1:-1);
            if(next>=0&&next<=length)reachable[nr][nc][next]=true;
        }
        return reachable[rows-1][columns-1][0];
    }
};
