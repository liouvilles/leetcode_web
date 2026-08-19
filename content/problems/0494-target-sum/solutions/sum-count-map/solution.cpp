class Solution {
    public: int findTargetSumWays(vector<int>& nums,int target){
        unordered_map<int,int> ways{
            {
                0,1
            }
        };
        for(int value:nums){
            unordered_map<int,int> next;
            for(auto [sum,count]:ways){
                next[sum+value]+=count;
                next[sum-value]+=count;
            }
            ways=move(next);
        }
        return ways[target];
    }
};
