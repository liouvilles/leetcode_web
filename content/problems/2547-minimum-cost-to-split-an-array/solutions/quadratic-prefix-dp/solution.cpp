class Solution {
    public:int minCost(vector<int>& nums,int k){
        int n=nums.size();
        vector<int> dp(n+1,INT_MAX/2);
        dp[0]=0;
        for(int left=0;left<n;++left){
            vector<int> frequency(n+1);
            int trimmed=0;
            for(int right=left;right<n;++right){
                int count=++frequency[nums[right]];
                if(count==2)trimmed+=2;
                else if(count>2)++trimmed;
                dp[right+1]=min(dp[right+1],dp[left]+k+trimmed);
            }
        }
        return dp[n];
    }
};
