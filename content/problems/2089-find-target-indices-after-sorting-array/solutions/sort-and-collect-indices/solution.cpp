class Solution {
    public: vector<int> targetIndices(vector<int>& nums,int target){
        sort(nums.begin(),nums.end());
        vector<int> answer;
        for(int i=0;i<(int)nums.size();++i)if(nums[i]==target)answer.push_back(i);
        return answer;
    }
};
