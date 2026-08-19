class Solution {
    public int numberOfStableArrays(int zero,int one,int limit){
        long mod=1000000007L;
        int[][] endZero=new int[zero+1][one+1],endOne=new int[zero+1][one+1];
        for(int count=1;count<=Math.min(zero,limit);count++)endZero[count][0]=1;
        for(int count=1;count<=Math.min(one,limit);count++)endOne[0][count]=1;
        for(int usedZero=1;usedZero<=zero;usedZero++)for(int usedOne=1;usedOne<=one;usedOne++){
            long ways=endZero[usedZero-1][usedOne]+(long)endOne[usedZero-1][usedOne];
            if(usedZero>limit)ways-=endOne[usedZero-limit-1][usedOne];
            endZero[usedZero][usedOne]=(int)((ways+mod)%mod);
            ways=endZero[usedZero][usedOne-1]+(long)endOne[usedZero][usedOne-1];
            if(usedOne>limit)ways-=endZero[usedZero][usedOne-limit-1];
            endOne[usedZero][usedOne]=(int)((ways+mod)%mod);
        }
        return (int)((endZero[zero][one]+(long)endOne[zero][one])%mod);
    }
}
