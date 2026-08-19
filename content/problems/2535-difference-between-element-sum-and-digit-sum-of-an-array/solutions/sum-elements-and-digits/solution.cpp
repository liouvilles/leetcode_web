class Solution {
    public:int differenceOfSum(vector<int>& nums){
        int elementSum=0,digitSum=0;
        for(int value:nums){
            elementSum+=value;
            for(int copy=value;copy;copy/=10)digitSum+=copy%10;
        }
        return abs(elementSum-digitSum);
    }
};
