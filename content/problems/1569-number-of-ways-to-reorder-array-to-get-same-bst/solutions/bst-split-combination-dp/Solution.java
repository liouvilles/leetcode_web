class Solution {
    private static final long MOD=1_000_000_007L;
    private long[][] combination;
    private long ways(List<Integer> values){
        if(values.size()<=2)return 1;
        int root=values.get(0);
        List<Integer> left=new ArrayList<>(),right=new ArrayList<>();
        for(int i=1;i<values.size();i++)if(values.get(i)<root)left.add(values.get(i));
        else right.add(values.get(i));
        return combination[values.size()-1][left.size()]*ways(left)%MOD*ways(right)%MOD;
    }
    public int numOfWays(int[] nums){
        int n=nums.length;
        combination=new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            combination[i][0]=combination[i][i]=1;
            for(int j=1;j<i;j++)combination[i][j]=(combination[i-1][j-1]+combination[i-1][j])%MOD;
        }
        List<Integer> values=new ArrayList<>();
        for(int value:nums)values.add(value);
        return (int)((ways(values)-1+MOD)%MOD);
    }
}
