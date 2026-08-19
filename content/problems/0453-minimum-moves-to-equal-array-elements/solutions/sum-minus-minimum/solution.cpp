class Solution {
    public: int minMoves(vector<int>& nums){
        long long sum=0;
        int minimum=INT_MAX;
        for(int value:nums){
            sum+=value;
            minimum=min(minimum,value);
        }
        return sum-1LL*minimum*nums.size();
    }
};
