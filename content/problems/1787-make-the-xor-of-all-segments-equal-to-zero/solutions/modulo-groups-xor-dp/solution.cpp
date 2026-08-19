class Solution {
    public: int minChanges(vector<int>& nums,int k){
        const int inf=1000000;
        vector<int> dp(1024,inf);
        dp[0]=0;
        for(int group=0;group<k;++group){
            vector<int> count(1024);
            int size=0;
            for(int i=group;i<(int)nums.size();i+=k){
                ++count[nums[i]];
                ++size;
            }
            int minimum=*min_element(dp.begin(),dp.end());
            vector<int> next(1024,minimum+size);
            for(int state=0;state<1024;++state)for(int value=0;value<1024;++value)if(count[value])next[state^value]=min(next[state^value],dp[state]+size-count[value]);
            dp.swap(next);
        }
        return dp[0];
    }
};
