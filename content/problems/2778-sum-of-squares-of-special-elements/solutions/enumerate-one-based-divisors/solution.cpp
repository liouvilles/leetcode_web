class Solution {
    public:int sumOfSquares(vector<int>& nums){
        int answer=0,n=nums.size();
        for(int i=0;i<n;++i)if(n%(i+1)==0)answer+=nums[i]*nums[i];
        return answer;
    }
};
