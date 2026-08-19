class Solution {
    fun busiestServers(k:Int,arrival:IntArray,load:IntArray):List<Int>{
        val available=java.util.TreeSet<Int>();
        for(server in 0 until k)available.add(server);
        val busy=java.util.PriorityQueue<LongArray>(compareBy{
            it[0]
        });
        val count=IntArray(k);
        for(i in arrival.indices){
            while(busy.isNotEmpty()&&busy.peek()[0]<=arrival[i])available.add(busy.remove()[1].toInt());
            if(available.isEmpty())continue;
            val server=available.ceiling(i%k)?:available.first();
            available.remove(server);
            count[server]++;
            busy.add(longArrayOf(arrival[i].toLong()+load[i],server.toLong()))
        };
        val maximum=count.maxOrNull()!!;
        return count.indices.filter{
            count[it]==maximum
        }
    }
}
