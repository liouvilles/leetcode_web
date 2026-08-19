class Solution {
    int gcdValue(int a,int b){
        while(b){
            int temporary=a%b;
            a=b;
            b=temporary;
        }
        return a;
    }
    public:int nthMagicalNumber(int n,int a,int b){
        long long lcm=(long long)a/gcdValue(a,b)*b,low=1,high=(long long)n*min(a,b);
        while(low<high){
            long long middle=low+(high-low)/2,count=middle/a+middle/b-middle/lcm;
            if(count>=n)high=middle;
            else low=middle+1;
        }
        return low%1000000007;
    }
};
