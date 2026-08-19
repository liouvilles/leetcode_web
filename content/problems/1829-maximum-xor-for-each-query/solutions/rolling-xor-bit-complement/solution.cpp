class Solution {
    public: vector<int> getMaximumXor(vector<int>& nums,int maximumBit){
        int current=accumulate(nums.begin(),nums.end(),0,bit_xor<int>()),mask=(1<<maximumBit)-1;
        vector<int> answer(nums.size());
        for(int query=0;query<(int)nums.size();++query){
            answer[query]=current^mask;
            current^=nums[nums.size()-1-query];
        }
        return answer;
    }
};
