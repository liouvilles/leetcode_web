class Solution {
    public: int minStartValue(vector<int>& nums){
        int prefix=0,minimum=0;
        for(int value:nums){
            prefix+=value;
            minimum=min(minimum,prefix);
        }
        return 1-minimum;
    }
};
