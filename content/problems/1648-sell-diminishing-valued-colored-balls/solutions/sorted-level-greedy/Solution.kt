class Solution {
    companion object{
        const val MOD=1_000_000_007L;
        const val INV2=500_000_004L
    };
    private fun rangeSum(low:Long,high:Long):Long{
        if(low>high)return 0;
        return ((low+high)%MOD)*((high-low+1)%MOD)%MOD*INV2%MOD
    };
    fun maxProfit(inventory:IntArray,orders:Int):Int{
        val levels=inventory.sortedDescending().map{
            it.toLong()
        }+0L;
        var remaining=orders.toLong();
        var profit=0L;
        for(i in inventory.indices){
            val high=levels[i];
            val low=levels[i+1];
            val width=i+1L;
            val available=(high-low)*width;
            if(remaining>=available){
                profit=(profit+rangeSum(low+1,high)*(width%MOD))%MOD;
                remaining-=available
            }else{
                val full=remaining/width;
                val newLow=high-full;
                val remainder=remaining%width;
                profit=(profit+rangeSum(newLow+1,high)*(width%MOD)+newLow*remainder)%MOD;
                break
            }
        };
        return profit.toInt()
    }
}
