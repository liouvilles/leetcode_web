class Solution {
    public int numberOfSets(int n,int k){
        int mod=1_000_000_007,limit=n+k-1,choose=2*k;
        long[][] combination=new long[limit+1][choose+1];
        for(int row=0;row<=limit;row++){
            combination[row][0]=1;
            for(int col=1;col<=Math.min(row,choose);col++)combination[row][col]=(combination[row-1][col-1]+combination[row-1][col])%mod;
        }
        return (int)combination[limit][choose];
    }
}
