class Solution {
    public:int minLengthAfterRemovals(vector<int>& nums){
        unordered_map<int,int> frequency;
        int maximumFrequency=0;
        for(int value:nums)maximumFrequency=max(maximumFrequency,++frequency[value]);
        return max(2*maximumFrequency-(int)nums.size(),(int)nums.size()%2);
    }
};
