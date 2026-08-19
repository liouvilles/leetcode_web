class Solution {
public:
    long long maximumValueSum(vector<int>& nums,int k,vector<vector<int>>& edges){
        long long sum=0,even=0,odd=LLONG_MIN/4;
        for(int value:nums){
            sum+=value;
            long long gain=(value^k)-(long long)value;
            long long nextEven=max(even,odd+gain);
            long long nextOdd=max(odd,even+gain);
            even=nextEven;
            odd=nextOdd;
        }
        return sum+even;
    }
};
