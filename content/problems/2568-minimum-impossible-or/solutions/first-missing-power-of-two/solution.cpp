class Solution { public:int minImpossibleOR(vector<int>& nums){unordered_set<int> values(nums.begin(),nums.end());int candidate=1;while(values.count(candidate))candidate<<=1;return candidate;} };
