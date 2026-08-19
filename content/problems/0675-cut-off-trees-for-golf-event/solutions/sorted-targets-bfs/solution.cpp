class Solution {
    int bfs(vector<vector<int>>& forest,int sr,int sc,int tr,int tc){
        if(sr==tr&&sc==tc)return 0;
        int rows=forest.size(),columns=forest[0].size();
        vector<vector<bool>> seen(rows,vector<bool>(columns));
        queue<pair<int,int>> pending;
        pending.push({
            sr,sc
        });
        seen[sr][sc]=true;
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
        },steps=0;
        while(!pending.empty()){
            ++steps;
            for(int size=pending.size();size>0;--size){
                auto [row,column]=pending.front();
                pending.pop();
                for(auto& d:directions){
                    int r=row+d[0],c=column+d[1];
                    if(r<0||r>=rows||c<0||c>=columns||seen[r][c]||forest[r][c]==0)continue;
                    if(r==tr&&c==tc)return steps;
                    seen[r][c]=true;
                    pending.push({
                        r,c
                    });
                }
            }
        }
        return -1;
    }
    public:int cutOffTree(vector<vector<int>>& forest){
        vector<array<int,3>> trees;
        for(int r=0;r<(int)forest.size();++r)for(int c=0;c<(int)forest[0].size();++c)if(forest[r][c]>1)trees.push_back({
            forest[r][c],r,c
        });
        sort(trees.begin(),trees.end());
        int row=0,column=0,total=0;
        for(auto tree:trees){
            int distance=bfs(forest,row,column,tree[1],tree[2]);
            if(distance<0)return -1;
            total+=distance;
            row=tree[1];
            column=tree[2];
        }
        return total;
    }
};
