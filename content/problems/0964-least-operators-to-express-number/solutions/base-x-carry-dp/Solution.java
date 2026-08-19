class Solution {
    public int leastOpsExpressTarget(int x,int target){
        int positive=0,negative=0,k=0;
        while(target>0){
            int digit=target%x;
            target/=x;
            if(k==0){
                positive=2*digit;
                negative=2*(x-digit);
            }else{
                int nextPositive=Math.min(positive+digit*k,negative+(digit+1)*k);
                int nextNegative=Math.min(positive+(x-digit)*k,negative+(x-digit-1)*k);
                positive=nextPositive;
                negative=nextNegative;
            }
            k++;
        }
        return Math.min(positive,negative+k)-1;
    }
}
