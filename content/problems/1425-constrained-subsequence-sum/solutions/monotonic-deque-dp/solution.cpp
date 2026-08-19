class Solution {
    public: int constrainedSubsetSum(vector<int>& nums,int k){
        vector<int> dp(nums.size());
        deque<int> pending;
        int answer=INT_MIN;
        for(int i=0;i<(int)nums.size();++i){
            while(!pending.empty()&&pending.front()<i-k)pending.pop_front();
            dp[i]=nums[i]+(pending.empty()?0:max(0,dp[pending.front()]));
            while(!pending.empty()&&dp[pending.back()]<=dp[i])pending.pop_back();
            pending.push_back(i);
            answer=max(answer,dp[i]);
        }
        return answer;
    }
};
