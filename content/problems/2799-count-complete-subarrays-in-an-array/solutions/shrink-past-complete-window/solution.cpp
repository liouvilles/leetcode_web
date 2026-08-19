class Solution {
    public:int countCompleteSubarrays(vector<int>& nums){
        unordered_set<int> all(nums.begin(),nums.end());
        unordered_map<int,int> frequency;
        int required=all.size(),distinct=0,left=0,answer=0;
        for(int value:nums){
            if(frequency[value]++==0)++distinct;
            while(distinct==required){
                int removed=nums[left++];
                if(--frequency[removed]==0)--distinct;
            }
            answer+=left;
        }
        return answer;
    }
};
