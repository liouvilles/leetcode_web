class Solution {
    public:int distinctAverages(vector<int>& nums){
        sort(nums.begin(),nums.end());
        unordered_set<int> sums;
        for(int left=0,right=nums.size()-1;left<right;++left,--right)sums.insert(nums[left]+nums[right]);
        return sums.size();
    }
};
