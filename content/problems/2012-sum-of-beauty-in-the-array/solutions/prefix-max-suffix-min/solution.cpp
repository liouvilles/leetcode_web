class Solution {
    public: int sumOfBeauties(vector<int>& nums){
        int n=nums.size();
        vector<int> left(n),right(n);
        partial_sum(nums.begin(),nums.end(),left.begin(),[](int a,int b){
            return max(a,b);
        });
        partial_sum(nums.rbegin(),nums.rend(),right.rbegin(),[](int a,int b){
            return min(a,b);
        });
        int answer=0;
        for(int i=1;i<n-1;++i)if(nums[i]>left[i-1]&&nums[i]<right[i+1])answer+=2;
        else if(nums[i]>nums[i-1]&&nums[i]<nums[i+1])++answer;
        return answer;
    }
};
