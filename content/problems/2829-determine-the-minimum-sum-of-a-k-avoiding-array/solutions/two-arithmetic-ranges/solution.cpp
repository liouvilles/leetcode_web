class Solution {
    public:int minimumSum(int n,int k){
        long long first=min(n,k/2),remaining=n-first;
        return first*(first+1)/2+remaining*(2LL*k+remaining-1)/2;
    }
};
