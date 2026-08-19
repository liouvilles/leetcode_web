class Solution {
    int cost(vector<int>& nums,int parity){
        int moves=0;
        for(int i=parity;i<(int)nums.size();i+=2){
            int left=i?nums[i-1]:1000000000,right=i+1<(int)nums.size()?nums[i+1]:1000000000;
            moves+=max(0,nums[i]-min(left,right)+1);
        }
        return moves;
    }
    public:int movesToMakeZigzag(vector<int>& nums){
        return min(cost(nums,0),cost(nums,1));
    }
};
