class Solution {
    public boolean checkPerfectNumber(int num){
        if(num<=1)return false;
        int sum=1;
        for(int divisor=2;(long)divisor*divisor<=num;divisor++)if(num%divisor==0){
            sum+=divisor;
            if(divisor!=num/divisor)sum+=num/divisor;
        }
        return sum==num;
    }
}
