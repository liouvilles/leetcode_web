class Solution {
    public:vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid,vector<int>& pricing,vector<int>& start,int k){
        int rows=grid.size(),columns=grid[0].size();
        vector<vector<bool>> seen(rows,vector<bool>(columns));
        queue<array<int,3>> pending;
        pending.push({
            start[0],start[1],0
        });
        seen[start[0]][start[1]]=true;
        vector<array<int,4>> items;
        int directions[5]={
            1,0,-1,0,1
        };
        while(!pending.empty()){
            auto [row,column,distance]=pending.front();
            pending.pop();
            int value=grid[row][column];
            if(value>1&&value>=pricing[0]&&value<=pricing[1])items.push_back({
                distance,value,row,column
            });
            for(int d=0;d<4;++d){
                int r=row+directions[d],c=column+directions[d+1];
                if(r>=0&&r<rows&&c>=0&&c<columns&&!seen[r][c]&&grid[r][c]){
                    seen[r][c]=true;
                    pending.push({
                        r,c,distance+1
                    });
                }
            }
        }
        sort(items.begin(),items.end());
        vector<vector<int>> answer;
        for(int i=0;i<min(k,(int)items.size());++i)answer.push_back({
            items[i][2],items[i][3]
        });
        return answer;
    }
};
