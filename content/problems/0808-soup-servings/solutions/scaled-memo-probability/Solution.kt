class Solution {
    private lateinit var memo:Array<Array<Double?>>;
    fun soupServings(n:Int):Double{
        if(n>4800)return 1.0;
        val units=(n+24)/25;
        memo=Array(units+1){
            arrayOfNulls(units+1)
        };
        return dfs(units,units)
    };
    private fun dfs(a:Int,b:Int):Double{
        if(a<=0&&b<=0)return 0.5;
        if(a<=0)return 1.0;
        if(b<=0)return 0.0;
        memo[a][b]?.let{
            return it
        };
        return(0.25*(dfs(a-4,b)+dfs(a-3,b-1)+dfs(a-2,b-2)+dfs(a-1,b-3))).also{
            memo[a][b]=it
        }
    }
}
