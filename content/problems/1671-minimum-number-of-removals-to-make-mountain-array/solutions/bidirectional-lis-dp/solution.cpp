class Solution {
    public: int minimumMountainRemovals(vector<int>& nums){
        int n=nums.size();
        vector<int> increasing(n,1),decreasing(n,1);
        for(int i=0;i<n;++i)for(int j=0;j<i;++j)if(nums[j]<nums[i])increasing[i]=max(increasing[i],increasing[j]+1);
        for(int i=n-1;i>=0;--i)for(int j=n-1;j>i;--j)if(nums[j]<nums[i])decreasing[i]=max(decreasing[i],decreasing[j]+1);
        int longest=0;
        for(int i=1;i+1<n;++i)if(increasing[i]>1&&decreasing[i]>1)longest=max(longest,increasing[i]+decreasing[i]-1);
        return n-longest;
    }
};
