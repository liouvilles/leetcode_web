class Solution {
    public:long long countSubarrays(vector<int>& nums,long long k){
        long long sum=0,answer=0;
        int left=0;
        for(int right=0;right<(int)nums.size();++right){
            sum+=nums[right];
            while(left<=right&&sum*(right-left+1)>=k)sum-=nums[left++];
            answer+=right-left+1;
        }
        return answer;
    }
};
