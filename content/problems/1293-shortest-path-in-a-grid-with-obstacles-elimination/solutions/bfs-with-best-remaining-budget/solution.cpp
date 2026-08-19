class Solution {
    public: int shortestPath(vector<vector<int>>& grid,int k){
        int rows=grid.size(),columns=grid[0].size();
        if(rows==1&&columns==1)return 0;
        vector<vector<int>> best(rows,vector<int>(columns,-1));
        queue<array<int,4>> pending;
        pending.push({
            0,0,k,0
        });
        best[0][0]=k;
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
        while(!pending.empty()){
            auto state=pending.front();
            pending.pop();
            for(auto& d:directions){
                int r=state[0]+d[0],c=state[1]+d[1];
                if(r<0||r>=rows||c<0||c>=columns)continue;
                int remaining=state[2]-grid[r][c];
                if(remaining<0||remaining<=best[r][c])continue;
                if(r==rows-1&&c==columns-1)return state[3]+1;
                best[r][c]=remaining;
                pending.push({
                    r,c,remaining,state[3]+1
                });
            }
        }
        return -1;
    }
};
