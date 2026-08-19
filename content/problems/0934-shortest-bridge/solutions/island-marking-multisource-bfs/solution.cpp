class Solution {
    public: int shortestBridge(vector<vector<int>>& grid){
        int n=grid.size();
        queue<pair<int,int>> flood,frontier;
        bool found=false;
        for(int r=0;r<n&&!found;++r)for(int c=0;c<n;++c)if(grid[r][c]==1){
            flood.push({
                r,c
            });
            grid[r][c]=2;
            found=true;
            break;
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
        while(!flood.empty()){
            auto cell=flood.front();
            flood.pop();
            frontier.push(cell);
            for(auto& d:directions){
                int r=cell.first+d[0],c=cell.second+d[1];
                if(r>=0&&r<n&&c>=0&&c<n&&grid[r][c]==1){
                    grid[r][c]=2;
                    flood.push({
                        r,c
                    });
                }
            }
        }
        int distance=0;
        while(!frontier.empty()){
            for(int size=frontier.size();size;--size){
                auto cell=frontier.front();
                frontier.pop();
                for(auto& d:directions){
                    int r=cell.first+d[0],c=cell.second+d[1];
                    if(r<0||r>=n||c<0||c>=n||grid[r][c]==2)continue;
                    if(grid[r][c]==1)return distance;
                    grid[r][c]=2;
                    frontier.push({
                        r,c
                    });
                }
            }
            ++distance;
        }
        return -1;
    }
};
