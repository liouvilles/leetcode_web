class Solution {
    public:int waysToSplitArray(vector<int>& nums){
        long long total=accumulate(nums.begin(),nums.end(),0LL),prefix=0;
        int answer=0;
        for(int i=0;i+1<(int)nums.size();++i){
            prefix+=nums[i];
            answer+=prefix>=total-prefix;
        }
        return answer;
    }
};
