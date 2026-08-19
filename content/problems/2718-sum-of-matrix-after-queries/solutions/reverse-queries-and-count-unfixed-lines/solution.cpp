class Solution {
    public:long long matrixSumQueries(int n,vector<vector<int>>& queries){
        vector<bool> seenRow(n),seenCol(n);
        int usedRows=0,usedCols=0;
        long long answer=0;
        for(int i=queries.size()-1;i>=0;--i){
            int type=queries[i][0],index=queries[i][1],value=queries[i][2];
            if(type==0&&!seenRow[index]){
                answer+=1LL*value*(n-usedCols);
                seenRow[index]=true;
                ++usedRows;
            }else if(type==1&&!seenCol[index]){
                answer+=1LL*value*(n-usedRows);
                seenCol[index]=true;
                ++usedCols;
            }
        }
        return answer;
    }
};
