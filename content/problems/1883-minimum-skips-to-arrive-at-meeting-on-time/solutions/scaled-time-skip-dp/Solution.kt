class Solution {
    fun minSkips(dist:IntArray,speed:Int,hoursBefore:Int):Int{
        val infinity=Long.MAX_VALUE/4;
        var dp=LongArray(dist.size+1){
            infinity
        };
        dp[0]=0;
        for(road in dist.indices){
            val next=LongArray(dist.size+1){
                infinity
            };
            for(skipped in 0..road)if(dp[skipped]<infinity){
                val arrival=dp[skipped]+dist[road];
                val waited=if(road==dist.lastIndex)arrival else (arrival+speed-1)/speed*speed;
                next[skipped]=minOf(next[skipped],waited);
                if(road<dist.lastIndex)next[skipped+1]=minOf(next[skipped+1],arrival)
            };
            dp=next
        };
        val limit=hoursBefore.toLong()*speed;
        for(skipped in dp.indices)if(dp[skipped]<=limit)return skipped;
        return -1
    }
}
