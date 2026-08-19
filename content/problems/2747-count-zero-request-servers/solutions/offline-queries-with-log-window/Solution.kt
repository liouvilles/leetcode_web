class Solution {
    fun countServers(n:Int,logs:Array<IntArray>,x:Int,queries:IntArray):IntArray{
        logs.sortWith(Comparator{
            a,b->a[1].compareTo(b[1])
        });
        val order=Array(queries.size){
            it
        };
        order.sortWith(Comparator{
            a,b->queries[a].compareTo(queries[b])
        });
        val frequency=IntArray(n+1);
        val answer=IntArray(queries.size);
        var left=0;
        var right=0;
        var active=0;
        for(queryIndex in order){
            val query=queries[queryIndex];
            while(right<logs.size&&logs[right][1]<=query){
                val server=logs[right++][0];
                if(frequency[server]++==0)active++
            };
            while(left<right&&logs[left][1]<query-x){
                val server=logs[left++][0];
                frequency[server]--;
                if(frequency[server]==0)active--
            };
            answer[queryIndex]=n-active
        };
        return answer
    }
}
