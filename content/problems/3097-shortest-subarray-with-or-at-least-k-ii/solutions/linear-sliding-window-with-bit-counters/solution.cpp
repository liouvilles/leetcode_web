class Solution {
    public:int minimumSubarrayLength(vector<int>& nums,int k){
        int bitCount[31]{
        },left=0,currentOr=0,answer=nums.size()+1;
        for(int right=0;right<(int)nums.size();++right){
            for(int bit=0;bit<31;++bit)if(nums[right]&(1<<bit)){
                ++bitCount[bit];
                currentOr|=1<<bit;
            }while(left<=right&&currentOr>=k){
                answer=min(answer,right-left+1);
                for(int bit=0;bit<31;++bit)if((nums[left]&(1<<bit))&&--bitCount[bit]==0)currentOr&=~(1<<bit);
                ++left;
            }
        }
        return answer==(int)nums.size()+1?-1:answer;
    }
};
