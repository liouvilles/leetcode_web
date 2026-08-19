class Solution {
    public:int sumOfPower(vector<int>& nums){
        const long long MOD=1'000'000'007;
        sort(nums.begin(),nums.end());
        long long answer=0,prefix=0;
        for(long long value:nums){
            long long square=value*value%MOD;
            answer=(answer+square*((value+prefix)%MOD))%MOD;
            prefix=(2*prefix+value)%MOD;
        }
        return answer;
    }
};
