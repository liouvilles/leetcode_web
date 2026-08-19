class Solution {
    public:long long countExcellentPairs(vector<int>& nums,int k){
        unordered_set<int> unique(nums.begin(),nums.end());
        long long frequency[31]={
        },answer=0;
        for(int value:unique)++frequency[__builtin_popcount(value)];
        for(int i=0;i<31;++i)for(int j=0;j<31;++j)if(i+j>=k)answer+=frequency[i]*frequency[j];
        return answer;
    }
};
