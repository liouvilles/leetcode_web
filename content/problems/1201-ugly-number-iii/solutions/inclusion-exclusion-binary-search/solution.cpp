class Solution {
    const long long LIMIT=2000000001LL;
    long long gcdValue(long long a,long long b){
        while(b){
            long long remainder=a%b;
            a=b;
            b=remainder;
        }
        return a;
    }
    long long lcmValue(long long a,long long b){
        long long divided=a/gcdValue(a,b);
        return divided>LIMIT/b?LIMIT:divided*b;
    }
    public:int nthUglyNumber(int n,int a,int b,int c){
        long long ab=lcmValue(a,b),ac=lcmValue(a,c),bc=lcmValue(b,c),abc=lcmValue(ab,c),left=1,right=2000000000LL;
        while(left<right){
            long long middle=(left+right)/2,count=middle/a+middle/b+middle/c-middle/ab-middle/ac-middle/bc+middle/abc;
            if(count>=n)right=middle;
            else left=middle+1;
        }
        return left;
    }
};
