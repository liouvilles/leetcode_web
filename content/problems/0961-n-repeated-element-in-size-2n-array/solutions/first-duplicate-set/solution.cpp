class Solution {
    public: int repeatedNTimes(vector<int>& nums){
        unordered_set<int> seen;
        for(int value:nums)if(!seen.insert(value).second)return value;
        return -1;
    }
};
