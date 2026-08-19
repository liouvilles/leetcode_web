class Solution {
    public: int mirrorReflection(int p,int q){
        int divisor=gcd(p,q);
        p/=divisor;
        q/=divisor;
        if(p%2==0)return 2;
        return q%2?1:0;
    }
};
