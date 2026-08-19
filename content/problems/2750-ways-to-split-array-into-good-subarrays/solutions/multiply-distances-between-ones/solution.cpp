class Solution {
    public:int numberOfGoodSubarraySplits(vector<int>& nums){
        const long long MOD=1000000007;
        long long answer=1;
        int previous=-1;
        for(int i=0;i<(int)nums.size();++i)if(nums[i]){
            if(previous!=-1)answer=answer*(i-previous)%MOD;
            previous=i;
        }
        return previous==-1?0:answer;
    }
};
