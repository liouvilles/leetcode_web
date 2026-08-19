class Solution {
    public: int fourSumCount(vector<int>& nums1,vector<int>& nums2,vector<int>& nums3,vector<int>& nums4){
        unordered_map<int,int> counts;
        for(int a:nums1)for(int b:nums2)++counts[a+b];
        int answer=0;
        for(int c:nums3)for(int d:nums4)answer+=counts[-c-d];
        return answer;
    }
};
