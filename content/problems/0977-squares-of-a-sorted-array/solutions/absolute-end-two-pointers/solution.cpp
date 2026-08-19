class Solution {
    public: vector<int> sortedSquares(vector<int>& nums){
        vector<int> answer(nums.size());
        int left=0,right=nums.size()-1;
        for(int write=nums.size()-1;write>=0;--write){
            int value=abs(nums[left])>abs(nums[right])?nums[left++]:nums[right--];
            answer[write]=value*value;
        }
        return answer;
    }
};
