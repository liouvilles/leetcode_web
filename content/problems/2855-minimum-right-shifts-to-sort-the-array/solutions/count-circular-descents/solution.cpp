class Solution {
    public:int minimumRightShifts(vector<int>& nums){
        int descents=0,boundary=-1,n=nums.size();
        for(int i=0;i<n;++i)if(nums[i]>nums[(i+1)%n]){
            ++descents;
            boundary=i;
        }
        if(descents>1)return -1;
        return descents? n-1-boundary:0;
    }
};
