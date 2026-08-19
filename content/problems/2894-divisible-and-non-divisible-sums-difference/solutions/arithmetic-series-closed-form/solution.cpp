class Solution { public:int differenceOfSums(int n,int m){int count=n/m,total=n*(n+1)/2,divisible=m*count*(count+1)/2;return total-2*divisible;} };
