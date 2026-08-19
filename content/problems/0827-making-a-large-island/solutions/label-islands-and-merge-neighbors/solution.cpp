class Solution {
    int paint(vector<vector<int>>& grid,int r,int c,int id){
        int n=grid.size();
        if(r<0||r>=n||c<0||c>=n||grid[r][c]!=1)return 0;
        grid[r][c]=id;
        return 1+paint(grid,r+1,c,id)+paint(grid,r-1,c,id)+paint(grid,r,c+1,id)+paint(grid,r,c-1,id);
    }
    public:int largestIsland(vector<vector<int>>& grid){
        int n=grid.size(),id=2,answer=0;
        unordered_map<int,int> area;
        for(int r=0;r<n;++r)for(int c=0;c<n;++c)if(grid[r][c]==1){
            int size=paint(grid,r,c,id);
            area[id]=size;
            answer=max(answer,size);
            ++id;
        }
        int directions[5]={
            -1,0,1,0,-1
        };
        for(int r=0;r<n;++r)for(int c=0;c<n;++c)if(grid[r][c]==0){
            int size=1;
            unordered_set<int> seen;
            for(int d=0;d<4;++d){
                int nr=r+directions[d],nc=c+directions[d+1];
                if(nr>=0&&nr<n&&nc>=0&&nc<n&&grid[nr][nc]>1&&seen.insert(grid[nr][nc]).second)size+=area[grid[nr][nc]];
            }
            answer=max(answer,size);
        }
        return answer;
    }
};
