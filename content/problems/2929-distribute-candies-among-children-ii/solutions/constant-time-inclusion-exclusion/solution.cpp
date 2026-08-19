class Solution {
    long long ways(long long sum){
        return sum<0?0:(sum+1)*(sum+2)/2;
    }
    public:long long distributeCandies(int n,int limit){
        long long step=limit+1LL;
        return ways(n)-3*ways(n-step)+3*ways(n-2*step)-ways(n-3*step);
    }
};
