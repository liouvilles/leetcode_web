class Solution {
    public:long long countBadPairs(vector<int>& nums){
        unordered_map<int,int> frequency;
        long long answer=0;
        for(int index=0;index<(int)nums.size();++index){
            int key=nums[index]-index;
            answer+=index-frequency[key];
            ++frequency[key];
        }
        return answer;
    }
};
