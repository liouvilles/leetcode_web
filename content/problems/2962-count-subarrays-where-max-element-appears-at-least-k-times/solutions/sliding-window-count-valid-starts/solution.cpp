class Solution {
    public:long long countSubarrays(vector<int>& nums,int k){
        int maximum=*max_element(nums.begin(),nums.end()),left=0,count=0;
        long long answer=0;
        for(int value:nums){
            if(value==maximum)++count;
            while(count>=k)if(nums[left++]==maximum)--count;
            answer+=left;
        }
        return answer;
    }
};
