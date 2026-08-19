class Solution {
    public: int dominantIndex(vector<int>& nums){
        int maximum=-1,second=-1,index=-1;
        for(int i=0;i<(int)nums.size();++i)if(nums[i]>maximum){
            second=maximum;
            maximum=nums[i];
            index=i;
        }else second=max(second,nums[i]);
        return 1LL*maximum>=2LL*second?index:-1;
    }
};
