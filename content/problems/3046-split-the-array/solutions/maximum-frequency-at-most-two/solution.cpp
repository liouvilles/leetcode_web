class Solution {
    public:bool isPossibleToSplit(vector<int>& nums){
        int frequency[101]{
        };
        for(int value:nums)if(++frequency[value]>2)return false;
        return true;
    }
};
