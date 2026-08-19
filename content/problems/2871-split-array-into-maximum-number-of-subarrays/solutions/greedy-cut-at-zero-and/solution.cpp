class Solution {
    public:int maxSubarrays(vector<int>& nums){
        int current=-1,answer=0;
        for(int value:nums){
            current&=value;
            if(!current){
                ++answer;
                current=-1;
            }
        }
        return max(answer,1);
    }
};
