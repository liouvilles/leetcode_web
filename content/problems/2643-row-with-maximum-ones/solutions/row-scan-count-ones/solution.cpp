class Solution {
    public:vector<int> rowAndMaximumOnes(vector<vector<int>>& mat){
        int bestRow=0,bestCount=0;
        for(int row=0;row<(int)mat.size();++row){
            int count=accumulate(mat[row].begin(),mat[row].end(),0);
            if(count>bestCount){
                bestCount=count;
                bestRow=row;
            }
        }
        return {
            bestRow,bestCount
        };
    }
};
