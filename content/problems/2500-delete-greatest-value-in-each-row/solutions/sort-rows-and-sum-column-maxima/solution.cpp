class Solution {
    public:int deleteGreatestValue(vector<vector<int>>& grid){
        for(auto& row:grid)sort(row.begin(),row.end());
        int answer=0;
        for(int col=0;col<(int)grid[0].size();++col){
            int maximum=0;
            for(auto& row:grid)maximum=max(maximum,row[col]);
            answer+=maximum;
        }
        return answer;
    }
};
