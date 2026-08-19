class Solution {
    private static final long MOD=1_000_000_007L;
    private long power(long base,long exponent){
        long answer=1;
        while(exponent>0){
            if((exponent&1)==1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    private long combination(int n,int exponent){
        long answer=1;
        for(int i=1;i<=exponent;i++)answer=answer*(n+i-1)%MOD*power(i,MOD-2)%MOD;
        return answer;
    }
    public int[] waysToFillArray(int[][] queries){
        int[] answer=new int[queries.length];
        for(int index=0;index<queries.length;index++){
            int n=queries[index][0],value=queries[index][1];
            long ways=1;
            for(int prime=2;prime*prime<=value;prime++)if(value%prime==0){
                int exponent=0;
                while(value%prime==0){
                    value/=prime;
                    exponent++;
                }
                ways=ways*combination(n,exponent)%MOD;
            }
            if(value>1)ways=ways*n%MOD;
            answer[index]=(int)ways;
        }
        return answer;
    }
}
