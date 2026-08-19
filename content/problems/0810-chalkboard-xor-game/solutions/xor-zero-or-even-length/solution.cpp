class Solution {
    public: bool xorGame(vector<int>& nums){
        int value=0;
        for(int number:nums)value^=number;
        return value==0||nums.size()%2==0;
    }
};
