class Solution { public:int minOperations(vector<int>& nums,int k){for(int value:nums)k^=value;return __builtin_popcount(k);} };
