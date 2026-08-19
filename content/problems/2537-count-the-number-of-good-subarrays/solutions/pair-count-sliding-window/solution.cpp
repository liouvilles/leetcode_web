class Solution {
    public:long long countGood(vector<int>& nums,int k){
        unordered_map<int,int> frequency;
        long long pairs=0,answer=0;
        int left=0;
        for(int right=0;right<(int)nums.size();++right){
            pairs+=frequency[nums[right]]++;
            while(pairs>=k){
                answer+=nums.size()-right;
                int removed=nums[left++];
                pairs-=--frequency[removed];
            }
        }
        return answer;
    }
};
