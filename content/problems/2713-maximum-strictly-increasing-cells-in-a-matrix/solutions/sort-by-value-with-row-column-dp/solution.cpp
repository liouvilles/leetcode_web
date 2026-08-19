class Solution {
    public:int maxIncreasingCells(vector<vector<int>>& mat){
        int rows=mat.size(),cols=mat[0].size();
        vector<array<int,3>> cells;
        for(int row=0;row<rows;++row)for(int col=0;col<cols;++col)cells.push_back({
            mat[row][col],row,col
        });
        sort(cells.begin(),cells.end());
        vector<int> rowBest(rows),colBest(cols);
        int answer=0;
        for(int start=0;start<(int)cells.size();){
            int end=start;
            while(end<(int)cells.size()&&cells[end][0]==cells[start][0])++end;
            vector<int> candidate(end-start);
            for(int i=start;i<end;++i){
                auto [value,row,col]=cells[i];
                candidate[i-start]=1+max(rowBest[row],colBest[col]);
                answer=max(answer,candidate[i-start]);
            }
            for(int i=start;i<end;++i){
                auto [value,row,col]=cells[i];
                rowBest[row]=max(rowBest[row],candidate[i-start]);
                colBest[col]=max(colBest[col],candidate[i-start]);
            }
            start=end;
        }
        return answer;
    }
};
