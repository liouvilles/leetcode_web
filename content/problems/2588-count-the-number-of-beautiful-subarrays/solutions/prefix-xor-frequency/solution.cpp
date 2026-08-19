class Solution {
    public:long long beautifulSubarrays(vector<int>& nums){
        unordered_map<int,int> frequency{
            {
                0,1
            }
        };
        int prefix=0;
        long long answer=0;
        for(int value:nums){
            prefix^=value;
            answer+=frequency[prefix];
            ++frequency[prefix];
        }
        return answer;
    }
};
