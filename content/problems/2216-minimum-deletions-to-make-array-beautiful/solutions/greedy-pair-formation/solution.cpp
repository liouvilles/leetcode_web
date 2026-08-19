class Solution {
    public:int minDeletion(vector<int>& nums){
        int deletions=0;
        for(int i=0;i+1<(int)nums.size();++i)if((i-deletions)%2==0&&nums[i]==nums[i+1])++deletions;
        if((nums.size()-deletions)%2)++deletions;
        return deletions;
    }
};
