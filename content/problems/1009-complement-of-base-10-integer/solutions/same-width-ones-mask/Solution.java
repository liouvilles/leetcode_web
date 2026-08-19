class Solution {
    public int bitwiseComplement(int n){
        if(n==0)return 1;
        int mask=0;
        for(int copy=n;copy>0;copy>>=1)mask=(mask<<1)|1;
        return n^mask;
    }
}
