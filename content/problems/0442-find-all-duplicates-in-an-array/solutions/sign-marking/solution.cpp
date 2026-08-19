class Solution {
    public: vector<int> findDuplicates(vector<int>& nums){
        vector<int> answer;
        for(int item:nums){
            int value=abs(item),index=value-1;
            if(nums[index]<0)answer.push_back(value);
            else nums[index]=-nums[index];
        }
        sort(answer.begin(),answer.end());
        return answer;
    }
};
