class Solution {
    public:int firstCompleteIndex(vector<int>& arr,vector<vector<int>>& mat){
        int rows=mat.size(),cols=mat[0].size();
        unordered_map<int,int> position;
        for(int row=0;row<rows;++row)for(int col=0;col<cols;++col)position[mat[row][col]]=row*cols+col;
        vector<int> rowCount(rows),colCount(cols);
        for(int i=0;i<(int)arr.size();++i){
            int encoded=position[arr[i]],row=encoded/cols,col=encoded%cols;
            if(++rowCount[row]==cols||++colCount[col]==rows)return i;
        }
        return -1;
    }
};
