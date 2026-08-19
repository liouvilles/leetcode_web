class Solution { public:bool canSplitArray(vector<int>& nums,int m){if(nums.size()<=2)return true;for(int i=1;i<(int)nums.size();++i)if(nums[i-1]+nums[i]>=m)return true;return false;} };
