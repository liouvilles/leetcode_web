class Solution {
    public:int maximumCount(vector<int>& nums){
        int negative=0,positive=0;
        for(int value:nums){
            negative+=value<0;
            positive+=value>0;
        }
        return max(negative,positive);
    }
};
