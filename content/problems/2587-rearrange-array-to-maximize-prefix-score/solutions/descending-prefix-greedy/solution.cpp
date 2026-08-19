class Solution {
    public:int maxScore(vector<int>& nums){
        sort(nums.rbegin(),nums.rend());
        long long sum=0;
        int answer=0;
        for(int value:nums){
            sum+=value;
            if(sum<=0)break;
            ++answer;
        }
        return answer;
    }
};
