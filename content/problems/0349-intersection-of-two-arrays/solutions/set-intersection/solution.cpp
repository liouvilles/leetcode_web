class Solution {
    public: vector<int> intersection(vector<int>& nums1,vector<int>& nums2){
        unordered_set<int> first(nums1.begin(),nums1.end());
        set<int> common;
        for(int value:nums2)if(first.count(value))common.insert(value);
        return vector<int>(common.begin(),common.end());
    }
};
