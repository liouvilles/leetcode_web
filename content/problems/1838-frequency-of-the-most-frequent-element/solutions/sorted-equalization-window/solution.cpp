class Solution {
    public: int maxFrequency(vector<int>& nums,int k){
        sort(nums.begin(),nums.end());
        int left=0,answer=0;
        long long sum=0;
        for(int right=0;right<(int)nums.size();++right){
            sum+=nums[right];
            while(1LL*nums[right]*(right-left+1)-sum>k)sum-=nums[left++];
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
