class Solution {
    public:int maximizeGreatness(vector<int>& nums){
        sort(nums.begin(),nums.end());
        int small=0,answer=0;
        for(int large=0;large<(int)nums.size();++large)if(nums[large]>nums[small]){
            ++small;
            ++answer;
        }
        return answer;
    }
};
