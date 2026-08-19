class Solution {
    public:int sumIndicesWithKSetBits(vector<int>& nums,int k){
        int answer=0;
        for(int index=0;index<(int)nums.size();++index)if(__builtin_popcount(index)==k)answer+=nums[index];
        return answer;
    }
};
