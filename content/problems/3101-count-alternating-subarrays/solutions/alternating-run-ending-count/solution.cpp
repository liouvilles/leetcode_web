class Solution {
    public:long long countAlternatingSubarrays(vector<int>& nums){
        long long answer=1,ending=1;
        for(int index=1;index<(int)nums.size();++index){
            ending=nums[index]!=nums[index-1]?ending+1:1;
            answer+=ending;
        }
        return answer;
    }
};
