class Solution {
    public: long long maxAlternatingSum(vector<int>& nums){
        long long plus=0,minus=0;
        for(int value:nums){
            long long oldPlus=plus,oldMinus=minus;
            plus=max(oldPlus,oldMinus+value);
            minus=max(oldMinus,oldPlus-value);
        }
        return plus;
    }
};
