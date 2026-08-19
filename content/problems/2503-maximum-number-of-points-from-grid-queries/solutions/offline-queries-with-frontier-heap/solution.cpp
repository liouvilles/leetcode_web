class Solution {
    public:vector<int> maxPoints(vector<vector<int>>& grid,vector<int>& queries){
        int rows=grid.size(),cols=grid[0].size();
        vector<int> order(queries.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return queries[a]<queries[b];
        });
        using Cell=array<int,3>;
        priority_queue<Cell,vector<Cell>,greater<Cell>> heap;
        vector<vector<bool>> visited(rows,vector<bool>(cols));
        heap.push({
            grid[0][0],0,0
        });
        visited[0][0]=true;
        vector<int> answer(queries.size());
        int count=0,directions[5]={
            1,0,-1,0,1
        };
        for(int index:order){
            while(!heap.empty()&&heap.top()[0]<queries[index]){
                auto cell=heap.top();
                heap.pop();
                ++count;
                for(int direction=0;direction<4;++direction){
                    int row=cell[1]+directions[direction],col=cell[2]+directions[direction+1];
                    if(row>=0&&row<rows&&col>=0&&col<cols&&!visited[row][col]){
                        visited[row][col]=true;
                        heap.push({
                            grid[row][col],row,col
                        });
                    }
                }
            }
            answer[index]=count;
        }
        return answer;
    }
};
