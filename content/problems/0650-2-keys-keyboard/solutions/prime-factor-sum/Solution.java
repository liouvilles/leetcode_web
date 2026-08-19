class Solution {
    public int minSteps(int n){
        int answer=0;
        for(int divisor=2;divisor*divisor<=n;divisor++)while(n%divisor==0){
            answer+=divisor;
            n/=divisor;
        }
        if(n>1)answer+=n;
        return answer;
    }
}
