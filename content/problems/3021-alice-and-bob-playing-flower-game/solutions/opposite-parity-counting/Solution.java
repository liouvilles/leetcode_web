class Solution { public long flowerGame(int n,int m){long oddN=(n+1L)/2,evenN=n/2,oddM=(m+1L)/2,evenM=m/2;return oddN*evenM+evenN*oddM;} }
