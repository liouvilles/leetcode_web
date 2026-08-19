class Solution {
    public: vector<int> kWeakestRows(vector<vector<int>>& mat,int k){
        vector<pair<int,int>> rows;
        for(int r=0;r<(int)mat.size();++r){
            int soldiers=lower_bound(mat[r].begin(),mat[r].end(),0,greater<int>())-mat[r].begin();
            rows.push_back({
                soldiers,r
            });
        }
        sort(rows.begin(),rows.end());
        vector<int> answer;
        for(int i=0;i<k;++i)answer.push_back(rows[i].second);
        return answer;
    }
};
