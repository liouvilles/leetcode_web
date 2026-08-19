class Solution {
    public:vector<long long> findPrefixScore(vector<int>& nums){
        vector<long long> answer(nums.size());
        int maximum=0;
        long long score=0;
        for(int i=0;i<(int)nums.size();++i){
            maximum=max(maximum,nums[i]);
            score+=nums[i]+maximum;
            answer[i]=score;
        }
        return answer;
    }
};
