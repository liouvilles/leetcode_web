class Solution {
    public: int smallestRangeI(vector<int>& nums,int k){
        auto [minimum,maximum]=minmax_element(nums.begin(),nums.end());
        return max(0,*maximum-*minimum-2*k);
    }
};
