class Solution {
    public: vector<vector<int>> diagonalSort(vector<vector<int>>& mat){
        unordered_map<int,vector<int>> groups;
        for(int r=0;r<(int)mat.size();++r)for(int c=0;c<(int)mat[0].size();++c)groups[r-c].push_back(mat[r][c]);
        for(auto& entry:groups)sort(entry.second.begin(),entry.second.end(),greater<int>());
        for(int r=0;r<(int)mat.size();++r)for(int c=0;c<(int)mat[0].size();++c){
            mat[r][c]=groups[r-c].back();
            groups[r-c].pop_back();
        }
        return mat;
    }
};
