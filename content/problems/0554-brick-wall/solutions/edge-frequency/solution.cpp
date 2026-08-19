class Solution {
    public: int leastBricks(vector<vector<int>>& wall){
        unordered_map<long long,int> counts;
        int maximum=0;
        for(auto& row:wall){
            long long position=0;
            for(int i=0;i+1<(int)row.size();++i){
                position+=row[i];
                maximum=max(maximum,++counts[position]);
            }
        }
        return wall.size()-maximum;
    }
};
