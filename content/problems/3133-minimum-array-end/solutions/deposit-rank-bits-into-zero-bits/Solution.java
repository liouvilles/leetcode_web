class Solution {
    public long minEnd(int n,int x){
        long remaining=n-1L,answer=x;
        int bit=0;
        while(remaining>0){
            long mask=1L<<bit;
            if((answer&mask)==0){
                if((remaining&1)==1)answer|=mask;
                remaining>>=1;
            }
            bit++;
        }
        return answer;
    }
}
