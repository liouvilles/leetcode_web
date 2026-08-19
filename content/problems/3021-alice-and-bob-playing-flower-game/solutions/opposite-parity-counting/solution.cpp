class Solution { public:long long flowerGame(int n,int m){long long oddN=(n+1LL)/2,evenN=n/2,oddM=(m+1LL)/2,evenM=m/2;return oddN*evenM+evenN*oddM;} };
