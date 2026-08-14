class Solution { public: vector<int> rearrangeArray(vector<int>& nums){sort(nums.begin(),nums.end());for(int i=1;i+1<(int)nums.size();i+=2)swap(nums[i],nums[i+1]);return nums;} };
