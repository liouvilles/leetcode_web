class Solution {
    public: vector<string> summaryRanges(vector<int>& nums){
        vector<string> answer;
        for(int start=0;start<(int)nums.size();){
            int end=start;
            while(end+1<(int)nums.size()&&(long long)nums[end+1]-nums[end]==1)++end;
            answer.push_back(start==end?to_string(nums[start]):to_string(nums[start])+"->"+to_string(nums[end]));
            start=end+1;
        }
        return answer;
    }
};
