class Solution {
    public: int maxResult(vector<int>& nums,int k){
        vector<int> dp(nums.size());
        dp[0]=nums[0];
        deque<int> candidates{
            0
        };
        for(int i=1;i<(int)nums.size();++i){
            while(candidates.front()<i-k)candidates.pop_front();
            dp[i]=nums[i]+dp[candidates.front()];
            while(!candidates.empty()&&dp[candidates.back()]<=dp[i])candidates.pop_back();
            candidates.push_back(i);
        }
        return dp.back();
    }
};
