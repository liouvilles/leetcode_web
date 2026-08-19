class Solution {
    public: vector<int> smallerNumbersThanCurrent(vector<int>& nums){
        int count[101]={
        };
        for(int value:nums)++count[value];
        int smaller=0;
        for(int value=0;value<=100;++value){
            int frequency=count[value];
            count[value]=smaller;
            smaller+=frequency;
        }
        for(int& value:nums)value=count[value];
        return nums;
    }
};
