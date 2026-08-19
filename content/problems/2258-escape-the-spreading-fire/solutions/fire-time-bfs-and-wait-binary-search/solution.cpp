class Solution {
    vector<vector<int>> grid,fire;
    int rows,columns;
    int directions[5]={
        1,0,-1,0,1
    };
    bool can(int wait){
        if(wait>=fire[0][0])return false;
        vector<vector<bool>> seen(rows,vector<bool>(columns));
        queue<array<int,3>> pending;
        pending.push({
            0,0,wait
        });
        seen[0][0]=true;
        while(!pending.empty()){
            auto [row,column,time]=pending.front();
            pending.pop();
            for(int d=0;d<4;++d){
                int r=row+directions[d],c=column+directions[d+1],arrival=time+1;
                if(r<0||r>=rows||c<0||c>=columns||seen[r][c]||grid[r][c]==2)continue;
                if(r==rows-1&&c==columns-1){
                    if(arrival<=fire[r][c])return true;
                    continue;
                }
                if(arrival>=fire[r][c])continue;
                seen[r][c]=true;
                pending.push({
                    r,c,arrival
                });
            }
        }
        return false;
    }
    public:int maximumMinutes(vector<vector<int>>& grid){
        this->grid=grid;
        rows=grid.size();
        columns=grid[0].size();
        int infinity=1100000000;
        fire.assign(rows,vector<int>(columns,infinity));
        queue<pair<int,int>> pending;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)if(grid[r][c]==1){
            fire[r][c]=0;
            pending.push({
                r,c
            });
        }while(!pending.empty()){
            auto [row,column]=pending.front();
            pending.pop();
            for(int d=0;d<4;++d){
                int r=row+directions[d],c=column+directions[d+1];
                if(r>=0&&r<rows&&c>=0&&c<columns&&grid[r][c]!=2&&fire[r][c]==infinity){
                    fire[r][c]=fire[row][column]+1;
                    pending.push({
                        r,c
                    });
                }
            }
        }
        if(!can(0))return -1;
        if(can(1000000000))return 1000000000;
        int left=0,right=1000000000;
        while(left<right){
            int middle=left+(right-left+1)/2;
            if(can(middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
};
