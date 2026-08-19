class Solution { public:long long maxArrayValue(vector<int>& nums){long long current=nums.back();for(int i=nums.size()-2;i>=0;--i)current=nums[i]<=current?current+nums[i]:nums[i];return current;} };
