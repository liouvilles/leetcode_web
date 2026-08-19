class Solution {
    public: int oddCells(int m,int n,vector<vector<int>>& indices){
        vector<bool> rows(m),columns(n);
        for(auto& index:indices){
            rows[index[0]]=!rows[index[0]];
            columns[index[1]]=!columns[index[1]];
        }
        int answer=0;
        for(bool row:rows)for(bool column:columns)answer+=row^column;
        return answer;
    }
};
