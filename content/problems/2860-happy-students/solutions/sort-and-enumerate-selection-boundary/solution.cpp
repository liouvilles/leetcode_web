class Solution {
    public:int countWays(vector<int>& nums){
        sort(nums.begin(),nums.end());
        int answer=0,n=nums.size();
        for(int selected=0;selected<=n;++selected)if((selected==0||nums[selected-1]<selected)&&(selected==n||nums[selected]>selected))++answer;
        return answer;
    }
};
