class Solution {
    public:long long minOperationsToMakeMedianK(vector<int>& nums,int k){
        sort(nums.begin(),nums.end());
        int middle=nums.size()/2;
        long long answer=0;
        for(int index=0;index<=middle;++index)if(nums[index]>k)answer+=(long long)nums[index]-k;
        for(int index=middle;index<(int)nums.size();++index)if(nums[index]<k)answer+=(long long)k-nums[index];
        return answer;
    }
};
