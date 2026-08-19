class Solution {
    public:vector<int> intersection(vector<vector<int>>& nums){
        map<int,int> count;
        for(auto& array:nums)for(int value:array)++count[value];
        vector<int> answer;
        for(auto [value,frequency]:count)if(frequency==(int)nums.size())answer.push_back(value);
        return answer;
    }
};
