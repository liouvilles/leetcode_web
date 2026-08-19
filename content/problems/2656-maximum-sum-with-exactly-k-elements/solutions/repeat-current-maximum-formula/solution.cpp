class Solution { public:int maximizeSum(vector<int>& nums,int k){int maximum=*max_element(nums.begin(),nums.end());return k*maximum+k*(k-1)/2;} };
