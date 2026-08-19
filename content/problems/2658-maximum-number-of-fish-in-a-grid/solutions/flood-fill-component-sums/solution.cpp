class Solution {
    public:int findMaxFish(vector<vector<int>>& grid){
        int rows=grid.size(),cols=grid[0].size(),answer=0,directions[5]={
            -1,0,1,0,-1
        };
        for(int startRow=0;startRow<rows;++startRow)for(int startCol=0;startCol<cols;++startCol)if(grid[startRow][startCol]>0){
            queue<pair<int,int>> pending;
            int fish=exchange(grid[startRow][startCol],0);
            pending.push({
                startRow,startCol
            });
            while(!pending.empty()){
                auto [currentRow,currentCol]=pending.front();
                pending.pop();
                for(int d=0;d<4;++d){
                    int row=currentRow+directions[d],col=currentCol+directions[d+1];
                    if(row>=0&&row<rows&&col>=0&&col<cols&&grid[row][col]>0){
                        fish+=exchange(grid[row][col],0);
                        pending.push({
                            row,col
                        });
                    }
                }
            }
            answer=max(answer,fish);
        }
        return answer;
    }
};
