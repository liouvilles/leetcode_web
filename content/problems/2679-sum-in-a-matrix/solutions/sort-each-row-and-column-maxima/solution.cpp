class Solution {
    public:int matrixSum(vector<vector<int>>& nums){
        for(auto& row:nums)sort(row.begin(),row.end());
        int answer=0;
        for(int col=0;col<(int)nums[0].size();++col){
            int maximum=0;
            for(auto& row:nums)maximum=max(maximum,row[col]);
            answer+=maximum;
        }
        return answer;
    }
};
