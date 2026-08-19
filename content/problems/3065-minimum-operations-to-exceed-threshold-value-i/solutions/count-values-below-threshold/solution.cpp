class Solution { public:int minOperations(vector<int>& nums,int k){int operations=0;for(int value:nums)if(value<k)++operations;return operations;} };
