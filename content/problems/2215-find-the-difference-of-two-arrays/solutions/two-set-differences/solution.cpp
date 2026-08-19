class Solution {
    public:vector<vector<int>> findDifference(vector<int>& nums1,vector<int>& nums2){
        set<int> first(nums1.begin(),nums1.end()),second(nums2.begin(),nums2.end());
        vector<vector<int>> answer(2);
        set_difference(first.begin(),first.end(),second.begin(),second.end(),back_inserter(answer[0]));
        set_difference(second.begin(),second.end(),first.begin(),first.end(),back_inserter(answer[1]));
        return answer;
    }
};
