class Solution {
    public:int maxSubarrayLength(vector<int>& nums,int k){
        unordered_map<int,int> frequency;
        int left=0,answer=0;
        for(int right=0;right<(int)nums.size();++right){
            ++frequency[nums[right]];
            while(frequency[nums[right]]>k)--frequency[nums[left++]];
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
