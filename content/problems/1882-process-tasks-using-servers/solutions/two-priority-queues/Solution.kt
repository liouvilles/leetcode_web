class Solution {
    fun assignTasks(servers:IntArray,tasks:IntArray):IntArray{
        val available=java.util.PriorityQueue<IntArray>(compareBy<IntArray>({
            it[0]
        },{
            it[1]
        }));
        val busy=java.util.PriorityQueue<LongArray>(compareBy<LongArray>({
            it[0]
        },{
            it[1]
        },{
            it[2]
        }));
        for(i in servers.indices)available.add(intArrayOf(servers[i],i));
        val answer=IntArray(tasks.size);
        var time=0L;
        for(i in tasks.indices){
            time=maxOf(time,i.toLong());
            if(available.isEmpty())time=maxOf(time,busy.peek()[0]);
            while(busy.isNotEmpty()&&busy.peek()[0]<=time){
                val server=busy.remove();
                available.add(intArrayOf(server[1].toInt(),server[2].toInt()))
            };
            val server=available.remove();
            answer[i]=server[1];
            busy.add(longArrayOf(time+tasks[i],server[0].toLong(),server[1].toLong()))
        };
        return answer
    }
}
