class Solution {
    public int numberOfWays(int startPos,int endPos,int k){
        int value=k+endPos-startPos;
        if((value&1)!=0)return 0;
        int right=value/2;
        if(right<0||right>k)return 0;
        long mod=1_000_000_007L;
        long[] ways=new long[k+1];
        ways[0]=1;
        for(int step=1;step<=k;step++)for(int count=step;count>=1;count--)ways[count]=(ways[count]+ways[count-1])%mod;
        return (int)ways[right];
    }
}
