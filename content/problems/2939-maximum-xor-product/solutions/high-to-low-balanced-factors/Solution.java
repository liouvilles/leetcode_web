class Solution {
    public int maximumXorProduct(long a,long b,int n){
        long first=(a>>n)<<n,second=(b>>n)<<n;
        for(int index=n-1;index>=0;index--){
            long bit=1L<<index;
            if(((a>>index)&1L)==((b>>index)&1L)){
                first|=bit;
                second|=bit;
            }else if(first<second)first|=bit;
            else second|=bit;
        }
        long mod=1_000_000_007L;
        return (int)((first%mod)*(second%mod)%mod);
    }
}
