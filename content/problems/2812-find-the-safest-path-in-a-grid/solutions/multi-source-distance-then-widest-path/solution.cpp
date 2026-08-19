class Solution {
    public:int maximumSafenessFactor(vector<vector<int>>& grid){
        int n=grid.size();
        vector distance(n,vector<int>(n,-1));
        queue<pair<int,int>> pending;
        for(int row=0;row<n;++row)for(int col=0;col<n;++col)if(grid[row][col]){
            distance[row][col]=0;
            pending.push({
                row,col
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
            auto [row,col]=pending.front();
            pending.pop();
            for(auto& direction:directions){
                int nextRow=row+direction[0],nextCol=col+direction[1];
                if(nextRow>=0&&nextRow<n&&nextCol>=0&&nextCol<n&&distance[nextRow][nextCol]==-1){
                    distance[nextRow][nextCol]=distance[row][col]+1;
                    pending.push({
                        nextRow,nextCol
                    });
                }
            }
        }
        vector best(n,vector<int>(n,-1));
        priority_queue<array<int,3>> heap;
        best[0][0]=distance[0][0];
        heap.push({
            best[0][0],0,0
        });
        while(!heap.empty()){
            auto [safety,row,col]=heap.top();
            heap.pop();
            if(safety<best[row][col])continue;
            if(row==n-1&&col==n-1)return safety;
            for(auto& direction:directions){
                int nextRow=row+direction[0],nextCol=col+direction[1];
                if(nextRow>=0&&nextRow<n&&nextCol>=0&&nextCol<n){
                    int candidate=min(safety,distance[nextRow][nextCol]);
                    if(candidate>best[nextRow][nextCol]){
                        best[nextRow][nextCol]=candidate;
                        heap.push({
                            candidate,nextRow,nextCol
                        });
                    }
                }
            }
        }
        return 0;
    }
};
