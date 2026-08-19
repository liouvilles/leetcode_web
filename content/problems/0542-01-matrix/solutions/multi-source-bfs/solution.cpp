class Solution {
    public: vector<vector<int>> updateMatrix(vector<vector<int>>& mat){
        int rows=mat.size(),cols=mat[0].size();
        vector<vector<int>> distance(rows,vector<int>(cols,-1));
        queue<pair<int,int>> pending;
        for(int r=0;r<rows;++r)for(int c=0;c<cols;++c)if(mat[r][c]==0){
            distance[r][c]=0;
            pending.push({
                r,c
            });
        }
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
            auto [row,column]=pending.front();
            pending.pop();
            for(auto& d:directions){
                int r=row+d[0],c=column+d[1];
                if(r>=0&&r<rows&&c>=0&&c<cols&&distance[r][c]==-1){
                    distance[r][c]=distance[row][column]+1;
                    pending.push({
                        r,c
                    });
                }
            }
        }
        return distance;
    }
};
