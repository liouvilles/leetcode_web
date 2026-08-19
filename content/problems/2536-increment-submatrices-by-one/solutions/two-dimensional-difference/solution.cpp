class Solution {
    public:vector<vector<int>> rangeAddQueries(int n,vector<vector<int>>& queries){
        vector<vector<int>> difference(n+1,vector<int>(n+1));
        for(auto& query:queries){
            int r1=query[0],c1=query[1],r2=query[2],c2=query[3];
            ++difference[r1][c1];
            --difference[r2+1][c1];
            --difference[r1][c2+1];
            ++difference[r2+1][c2+1];
        }
        vector<vector<int>> answer(n,vector<int>(n));
        for(int row=0;row<n;++row)for(int col=0;col<n;++col)answer[row][col]=difference[row][col]+(row?answer[row-1][col]:0)+(col?answer[row][col-1]:0)-(row&&col?answer[row-1][col-1]:0);
        return answer;
    }
};
