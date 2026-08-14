class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        int best = dp[0];
        for (int i = 1; i < (int)nums.size(); ++i) {
            dp[i] = max(nums[i], dp[i - 1] + nums[i]);
            best = max(best, dp[i]);
        }
        return best;
    }
};
