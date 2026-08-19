class Solution {
    private lateinit var events:Array<IntArray>;
    private lateinit var memo:Array<IntArray>;
    private fun next(end:Int):Int{
        var left=0;
        var right=events.size;
        while(left<right){
            val mid=(left+right) ushr 1;
            if(events[mid][0]<=end)left=mid+1 else right=mid
        };
        return left
    };
    private fun dfs(index:Int,remaining:Int):Int{
        if(index==events.size||remaining==0)return 0;
        if(memo[index][remaining]>=0)return memo[index][remaining];
        memo[index][remaining]=maxOf(dfs(index+1,remaining),events[index][2]+dfs(next(events[index][1]),remaining-1));
        return memo[index][remaining]
    };
    fun maxValue(events:Array<IntArray>,k:Int):Int{
        events.sortBy{
            it[0]
        };
        this.events=events;
        memo=Array(events.size){
            IntArray(k+1){
                -1
            }
        };
        return dfs(0,k)
    }
}
