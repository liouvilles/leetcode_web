class Solution {
    private static final long MOD=1_000_000_007L,INV2=500_000_004L;
    private long rangeSum(long low,long high){
        if(low>high)return 0;
        return ((low+high)%MOD)*((high-low+1)%MOD)%MOD*INV2%MOD;
    }
    public int maxProfit(int[] inventory,int orders){
        Integer[] levels=Arrays.stream(inventory).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        long remaining=orders,profit=0;
        for(int i=0;i<levels.length;i++){
            long high=levels[i],low=i+1<levels.length?levels[i+1]:0,width=i+1L,available=(high-low)*width;
            if(remaining>=available){
                profit=(profit+rangeSum(low+1,high)*(width%MOD))%MOD;
                remaining-=available;
            }else{
                long full=remaining/width,newLow=high-full,remainder=remaining%width;
                profit=(profit+rangeSum(newLow+1,high)*(width%MOD)+newLow*remainder)%MOD;
                break;
            }
        }
        return (int)profit;
    }
}
