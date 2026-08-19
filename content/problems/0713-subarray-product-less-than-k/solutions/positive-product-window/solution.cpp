class Solution {
    public: int numSubarrayProductLessThanK(vector<int>& nums,int k){
        if(k<=1)return 0;
        long long product=1;
        int left=0,answer=0;
        for(int right=0;right<(int)nums.size();++right){
            product*=nums[right];
            while(product>=k)product/=nums[left++];
            answer+=right-left+1;
        }
        return answer;
    }
};
