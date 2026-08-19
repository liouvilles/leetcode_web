class Solution {
    public:bool canSortArray(vector<int>& nums){
        int previousMax=0;
        for(int left=0;left<(int)nums.size();){
            int count=__builtin_popcount(nums[left]),right=left,currentMin=nums[left],currentMax=nums[left];
            while(right+1<(int)nums.size()&&__builtin_popcount(nums[right+1])==count){
                ++right;
                currentMin=min(currentMin,nums[right]);
                currentMax=max(currentMax,nums[right]);
            }
            if(previousMax>currentMin)return false;
            previousMax=currentMax;
            left=right+1;
        }
        return true;
    }
};
