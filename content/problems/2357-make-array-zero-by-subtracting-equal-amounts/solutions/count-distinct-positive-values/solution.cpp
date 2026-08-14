class Solution { public:int minimumOperations(vector<int>& nums){unordered_set<int> positive;for(int value:nums)if(value)positive.insert(value);return positive.size();} };
