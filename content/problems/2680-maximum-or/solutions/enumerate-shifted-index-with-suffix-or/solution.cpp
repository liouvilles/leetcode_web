class Solution {
    public:long long maximumOr(vector<int>& nums,int k){
        vector<long long> suffix(nums.size()+1);
        for(int i=nums.size()-1;i>=0;--i)suffix[i]=suffix[i+1]|nums[i];
        long long prefix=0,answer=0;
        for(int i=0;i<(int)nums.size();++i){
            answer=max(answer,prefix|(1LL*nums[i]<<k)|suffix[i+1]);
            prefix|=nums[i];
        }
        return answer;
    }
};
