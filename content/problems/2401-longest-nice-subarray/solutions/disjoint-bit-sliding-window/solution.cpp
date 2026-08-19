class Solution {
    public:int longestNiceSubarray(vector<int>& nums){
        int mask=0,left=0,answer=0;
        for(int right=0;right<(int)nums.size();++right){
            while(mask&nums[right])mask^=nums[left++];
            mask|=nums[right];
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
