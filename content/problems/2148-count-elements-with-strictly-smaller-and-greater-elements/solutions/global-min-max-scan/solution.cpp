class Solution {
    public:int countElements(vector<int>& nums){
        auto [minimum,maximum]=minmax_element(nums.begin(),nums.end());
        return count_if(nums.begin(),nums.end(),[&](int value){
            return value>*minimum&&value<*maximum;
        });
    }
};
