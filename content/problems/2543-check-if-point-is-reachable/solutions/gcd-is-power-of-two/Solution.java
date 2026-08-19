class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int remainder=a%b;
            a=b;
            b=remainder;
        }
        return a;
    }
    public boolean isReachable(int targetX,int targetY){
        int divisor=gcd(targetX,targetY);
        return (divisor&(divisor-1))==0;
    }
}
