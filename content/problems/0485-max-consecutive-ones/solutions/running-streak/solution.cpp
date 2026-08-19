class Solution {
    public: int findMaxConsecutiveOnes(vector<int>& nums){
        int current=0,best=0;
        for(int value:nums){
            current=value?current+1:0;
            best=max(best,current);
        }
        return best;
    }
};
