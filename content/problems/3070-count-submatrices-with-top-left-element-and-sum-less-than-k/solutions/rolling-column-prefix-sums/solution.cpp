class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid,int k){
        vector<long long> columnSums(grid[0].size());
        int answer=0;
        for(auto& row:grid){
            long long prefix=0;
            for(int column=0;column<(int)row.size();++column){
                columnSums[column]+=row[column];
                prefix+=columnSums[column];
                answer+=prefix<=k;
            }
        }
        return answer;
    }
};
