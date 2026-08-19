class Solution {
    public:vector<vector<int>> modifiedMatrix(vector<vector<int>>& matrix){
        for(int column=0;column<(int)matrix[0].size();++column){
            int maximum=0;
            for(auto& row:matrix)maximum=max(maximum,row[column]);
            for(auto& row:matrix)if(row[column]==-1)row[column]=maximum;
        }
        return matrix;
    }
};
