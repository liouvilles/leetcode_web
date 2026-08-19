class Solution {
    public: int maxSubarraySumCircular(vector<int>& nums){
        int total=nums[0],currentMax=nums[0],bestMax=nums[0],currentMin=nums[0],bestMin=nums[0];
        for(int i=1;i<(int)nums.size();++i){
            int value=nums[i];
            currentMax=max(value,currentMax+value);
            bestMax=max(bestMax,currentMax);
            currentMin=min(value,currentMin+value);
            bestMin=min(bestMin,currentMin);
            total+=value;
        }
        return bestMax<0?bestMax:max(bestMax,total-bestMin);
    }
};
