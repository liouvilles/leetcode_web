class Solution {
    public:int minimumSum(vector<int>& nums){
        int n=nums.size();
        vector<int> rightMinimum(n);
        rightMinimum[n-1]=nums[n-1];
        for(int i=n-2;i>=0;--i)rightMinimum[i]=min(nums[i],rightMinimum[i+1]);
        int leftMinimum=nums[0],answer=INT_MAX;
        for(int j=1;j<n-1;++j){
            if(leftMinimum<nums[j]&&rightMinimum[j+1]<nums[j])answer=min(answer,leftMinimum+nums[j]+rightMinimum[j+1]);
            leftMinimum=min(leftMinimum,nums[j]);
        }
        return answer==INT_MAX?-1:answer;
    }
};
