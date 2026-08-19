class Solution {
    public: int countPrimes(int n){
        vector<bool> composite(n);
        for(int p=2;(long long)p*p<n;++p)if(!composite[p])for(int value=p*p;value<n;value+=p)composite[value]=true;
        int count=0;
        for(int value=2;value<n;++value)if(!composite[value])++count;
        return count;
    }
};
