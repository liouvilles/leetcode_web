class Solution { public: int kthFactor(int n,int k){for(int value=1;value<=n;++value)if(n%value==0&&!--k)return value;return -1;} };
