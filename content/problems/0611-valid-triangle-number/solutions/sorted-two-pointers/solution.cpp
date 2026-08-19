class Solution {
    public: int triangleNumber(vector<int>& nums){
        sort(nums.begin(),nums.end());
        int answer=0;
        for(int longest=nums.size()-1;longest>=2;--longest){
            int left=0,right=longest-1;
            while(left<right)if(nums[left]+nums[right]>nums[longest]){
                answer+=right-left;
                --right;
            }else ++left;
        }
        return answer;
    }
};
