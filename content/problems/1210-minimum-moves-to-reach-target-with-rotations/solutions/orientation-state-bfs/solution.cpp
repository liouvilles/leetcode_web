class Solution {
    public: int minimumMoves(vector<vector<int>>& grid){
        int n=grid.size();
        queue<array<int,4>> pending;
        vector<vector<array<bool,2>>> seen(n,vector<array<bool,2>>(n,{
            false,false
        }));
        auto add=[&](int r,int c,int orientation,int distance){
            if(!seen[r][c][orientation]){
                seen[r][c][orientation]=true;
                pending.push({
                    r,c,orientation,distance
                });
            }
        };
        add(0,0,0,0);
        while(!pending.empty()){
            auto state=pending.front();
            pending.pop();
            int r=state[0],c=state[1],orientation=state[2],distance=state[3];
            if(r==n-1&&c==n-2&&!orientation)return distance;
            if(!orientation){
                if(c+2<n&&!grid[r][c+2])add(r,c+1,0,distance+1);
                if(r+1<n&&!grid[r+1][c]&&!grid[r+1][c+1]){
                    add(r+1,c,0,distance+1);
                    add(r,c,1,distance+1);
                }
            }else{
                if(r+2<n&&!grid[r+2][c])add(r+1,c,1,distance+1);
                if(c+1<n&&!grid[r][c+1]&&!grid[r+1][c+1]){
                    add(r,c+1,1,distance+1);
                    add(r,c,0,distance+1);
                }
            }
        }
        return -1;
    }
};
