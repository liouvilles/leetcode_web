class Solution {
    public:long long zeroFilledSubarray(vector<int>& nums){
        long long run=0,answer=0;
        for(int value:nums){
            run=value==0?run+1:0;
            answer+=run;
        }
        return answer;
    }
};
