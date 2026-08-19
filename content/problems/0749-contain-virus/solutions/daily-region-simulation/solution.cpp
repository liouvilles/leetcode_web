class Solution {
    vector<vector<int>> grid;
    int rows,columns;
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
    void dfs(int row,int column,vector<vector<bool>>& seen,vector<int>& region,set<int>& frontier,int& walls){
        seen[row][column]=true;
        region.push_back(row*columns+column);
        for(auto& d:directions){
            int r=row+d[0],c=column+d[1];
            if(r<0||r>=rows||c<0||c>=columns)continue;
            if(grid[r][c]==0){
                frontier.insert(r*columns+c);
                ++walls;
            }else if(grid[r][c]==1&&!seen[r][c])dfs(r,c,seen,region,frontier,walls);
        }
    }
    public:int containVirus(vector<vector<int>>& isInfected){
        grid=isInfected;
        rows=grid.size();
        columns=grid[0].size();
        int total=0;
        while(true){
            vector<vector<bool>> seen(rows,vector<bool>(columns));
            vector<vector<int>> regions;
            vector<set<int>> frontiers;
            vector<int> walls;
            for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)if(grid[r][c]==1&&!seen[r][c]){
                regions.push_back({
                });
                frontiers.push_back({
                });
                walls.push_back(0);
                dfs(r,c,seen,regions.back(),frontiers.back(),walls.back());
            }
            if(regions.empty())break;
            int chosen=max_element(frontiers.begin(),frontiers.end(),[](auto& a,auto& b){
                return a.size()<b.size();
            })-frontiers.begin();
            if(frontiers[chosen].empty())break;
            total+=walls[chosen];
            for(int code:regions[chosen])grid[code/columns][code%columns]=-1;
            for(int i=0;i<(int)frontiers.size();++i)if(i!=chosen)for(int code:frontiers[i])grid[code/columns][code%columns]=1;
        }
        return total;
    }
};
