class Solution {
    public: int minimumDeletions(vector<int>& nums){
        int minimum=min_element(nums.begin(),nums.end())-nums.begin(),maximum=max_element(nums.begin(),nums.end())-nums.begin(),first=min(minimum,maximum),second=max(minimum,maximum);
        return min({
            second+1,(int)nums.size()-first,first+1+(int)nums.size()-second
        });
    }
};
