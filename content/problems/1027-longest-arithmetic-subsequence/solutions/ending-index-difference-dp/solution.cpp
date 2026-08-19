class Solution {
    public: int longestArithSeqLength(vector<int>& nums){
        vector<unordered_map<int,int>> dp(nums.size());
        int answer=2;
        for(int i=0;i<(int)nums.size();++i)for(int j=0;j<i;++j){
            int difference=nums[i]-nums[j],length=(dp[j].count(difference)?dp[j][difference]:1)+1;
            dp[i][difference]=max(dp[i][difference],length);
            answer=max(answer,length);
        }
        return answer;
    }
};
