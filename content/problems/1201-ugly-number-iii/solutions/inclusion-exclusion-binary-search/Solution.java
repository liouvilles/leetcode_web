class Solution {
    private static final long LIMIT=2000000001L;
    public int nthUglyNumber(int n,int a,int b,int c){
        long ab=lcm(a,b),ac=lcm(a,c),bc=lcm(b,c),abc=lcm(ab,c),left=1,right=2000000000L;
        while(left<right){
            long middle=(left+right)/2;
            long count=middle/a+middle/b+middle/c-middle/ab-middle/ac-middle/bc+middle/abc;
            if(count>=n)right=middle;
            else left=middle+1;
        }
        return (int)left;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long remainder=a%b;
            a=b;
            b=remainder;
        }
        return a;
    }
    private long lcm(long a,long b){
        long divided=a/gcd(a,b);
        return divided>LIMIT/b?LIMIT:divided*b;
    }
}
