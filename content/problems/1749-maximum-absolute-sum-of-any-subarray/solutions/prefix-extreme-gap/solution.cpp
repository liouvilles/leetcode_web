class Solution {
    public: int maxAbsoluteSum(vector<int>& nums){
        int prefix=0,minimum=0,maximum=0;
        for(int value:nums){
            prefix+=value;
            minimum=min(minimum,prefix);
            maximum=max(maximum,prefix);
        }
        return maximum-minimum;
    }
};
