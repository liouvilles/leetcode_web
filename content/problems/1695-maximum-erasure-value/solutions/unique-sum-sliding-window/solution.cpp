class Solution {
    public: int maximumUniqueSubarray(vector<int>& nums){
        unordered_set<int> seen;
        int left=0,sum=0,answer=0;
        for(int value:nums){
            while(seen.count(value)){
                seen.erase(nums[left]);
                sum-=nums[left++];
            }
            seen.insert(value);
            sum+=value;
            answer=max(answer,sum);
        }
        return answer;
    }
};
