class Solution {
    public:long long minimumReplacement(vector<int>& nums){
        long long answer=0,limit=nums.back();
        for(int i=nums.size()-2;i>=0;--i){
            long long parts=(nums[i]+limit-1)/limit;
            answer+=parts-1;
            limit=nums[i]/parts;
        }
        return answer;
    }
};
