class Solution {
    public:int longestAlternatingSubarray(vector<int>& nums,int threshold){
        int current=0,answer=0;
        for(int i=0;i<(int)nums.size();++i){
            if(nums[i]>threshold)current=0;
            else if(!current)current=nums[i]%2==0;
            else if(nums[i]%2!=nums[i-1]%2)++current;
            else current=nums[i]%2==0;
            answer=max(answer,current);
        }
        return answer;
    }
};
