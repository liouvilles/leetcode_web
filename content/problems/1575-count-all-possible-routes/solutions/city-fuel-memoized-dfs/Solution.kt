class Solution {
    private lateinit var locations:IntArray;
    private var finish=0;
    private lateinit var memo:Array<IntArray>;
    private val mod=1_000_000_007;
    private fun dfs(city:Int,fuel:Int):Int{
        if(memo[city][fuel]!=-1)return memo[city][fuel];
        var answer=if(city==finish)1L else 0L;
        for(next in locations.indices)if(next!=city){
            val cost=kotlin.math.abs(locations[city]-locations[next]);
            if(cost<=fuel)answer+=dfs(next,fuel-cost)
        };
        memo[city][fuel]=(answer%mod).toInt();
        return memo[city][fuel]
    };
    fun countRoutes(locations:IntArray,start:Int,finish:Int,fuel:Int):Int{
        this.locations=locations;
        this.finish=finish;
        memo=Array(locations.size){
            IntArray(fuel+1){
                -1
            }
        };
        return dfs(start,fuel)
    }
}
