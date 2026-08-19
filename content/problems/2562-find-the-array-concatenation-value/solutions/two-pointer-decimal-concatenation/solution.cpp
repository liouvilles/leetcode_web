class Solution {
    public:long long findTheArrayConcVal(vector<int>& nums){
        long long answer=0;
        for(int left=0,right=nums.size()-1;left<=right;++left,--right)answer+=left==right?nums[left]:stoll(to_string(nums[left])+to_string(nums[right]));
        return answer;
    }
};
