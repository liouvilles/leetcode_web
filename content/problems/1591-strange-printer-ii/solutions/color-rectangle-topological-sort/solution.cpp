class Solution {
    public: bool isPrintable(vector<vector<int>>& grid){
        int colors=61,rows=grid.size(),cols=grid[0].size();
        vector<int> minRow(colors,rows),maxRow(colors),minCol(colors,cols),maxCol(colors),indegree(colors);
        vector<bool> present(colors);
        for(int row=0;row<rows;++row)for(int col=0;col<cols;++col){
            int color=grid[row][col];
            present[color]=true;
            minRow[color]=min(minRow[color],row);
            maxRow[color]=max(maxRow[color],row);
            minCol[color]=min(minCol[color],col);
            maxCol[color]=max(maxCol[color],col);
        }
        vector<vector<bool>> edge(colors,vector<bool>(colors));
        int total=0;
        for(int color=1;color<colors;++color)if(present[color]){
            ++total;
            for(int row=minRow[color];row<=maxRow[color];++row)for(int col=minCol[color];col<=maxCol[color];++col){
                int other=grid[row][col];
                if(other!=color&&!edge[color][other]){
                    edge[color][other]=true;
                    ++indegree[other];
                }
            }
        }
        queue<int> pending;
        for(int color=1;color<colors;++color)if(present[color]&&!indegree[color])pending.push(color);
        int processed=0;
        while(!pending.empty()){
            int color=pending.front();
            pending.pop();
            ++processed;
            for(int other=1;other<colors;++other)if(edge[color][other]&&!--indegree[other])pending.push(other);
        }
        return processed==total;
    }
};
