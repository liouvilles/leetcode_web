class Solution {
    vector<int> nums,multipliers;
    vector<vector<int>> memo;
    int dfs(int step,int left){
        if(step==(int)multipliers.size())return 0;
        int& answer=memo[step][left];
        if(answer!=INT_MIN)return answer;
        int right=nums.size()-1-(step-left);
        return answer=max(nums[left]*multipliers[step]+dfs(step+1,left+1),nums[right]*multipliers[step]+dfs(step+1,left));
    }
    public:int maximumScore(vector<int>& input,vector<int>& factors){
        nums=input;
        multipliers=factors;
        memo.assign(factors.size(),vector<int>(factors.size(),INT_MIN));
        return dfs(0,0);
    }
};
