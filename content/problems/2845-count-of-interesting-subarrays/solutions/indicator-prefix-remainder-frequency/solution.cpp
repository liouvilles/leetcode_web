class Solution {
    public:long long countInterestingSubarrays(vector<int>& nums,int modulo,int k){
        unordered_map<int,long long> frequency;
        frequency[0]=1;
        int prefix=0;
        long long answer=0;
        for(int value:nums){
            if(value%modulo==k)++prefix;
            int remainder=prefix%modulo,needed=(remainder-k+modulo)%modulo;
            answer+=frequency[needed];
            ++frequency[remainder];
        }
        return answer;
    }
};
