class Solution {
    public:long long maximumSubarraySum(vector<int>& nums,int k){
        unordered_map<int,int> frequency;
        long long sum=0,answer=0;
        int left=0;
        for(int right=0;right<(int)nums.size();++right){
            sum+=nums[right];
            ++frequency[nums[right]];
            if(right-left+1>k){
                int value=nums[left++];
                sum-=value;
                if(!--frequency[value])frequency.erase(value);
            }
            if(right-left+1==k&&(int)frequency.size()==k)answer=max(answer,sum);
        }
        return answer;
    }
};
