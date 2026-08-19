class Solution {
    public:bool isReachable(int targetX,int targetY){
        int divisor=gcd(targetX,targetY);
        return (divisor&(divisor-1))==0;
    }
};
