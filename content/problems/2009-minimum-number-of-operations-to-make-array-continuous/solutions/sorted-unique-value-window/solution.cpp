class Solution {
    public: int minOperations(vector<int>& nums){
        int n=nums.size();
        sort(nums.begin(),nums.end());
        nums.erase(unique(nums.begin(),nums.end()),nums.end());
        int left=0,maximum=0;
        for(int right=0;right<(int)nums.size();++right){
            while(nums[right]>=nums[left]+n)++left;
            maximum=max(maximum,right-left+1);
        }
        return n-maximum;
    }
};
