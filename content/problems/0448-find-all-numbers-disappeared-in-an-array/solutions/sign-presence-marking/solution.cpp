class Solution {
    public: vector<int> findDisappearedNumbers(vector<int>& nums){
        for(int item:nums){
            int index=abs(item)-1;
            nums[index]=-abs(nums[index]);
        }
        vector<int> answer;
        for(int i=0;i<(int)nums.size();++i)if(nums[i]>0)answer.push_back(i+1);
        return answer;
    }
};
