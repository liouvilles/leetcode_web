class Solution {
    public: int numberOfArithmeticSlices(vector<int>& nums){
        int current=0,answer=0;
        for(int i=2;i<(int)nums.size();++i){
            if((long long)nums[i]-nums[i-1]==(long long)nums[i-1]-nums[i-2])++current;
            else current=0;
            answer+=current;
        }
        return answer;
    }
};
