class Solution {
    fun getOrder(tasks:Array<IntArray>):IntArray{
        val indexed=tasks.indices.map{
            intArrayOf(tasks[it][0],tasks[it][1],it)
        }.sortedBy{
            it[0]
        };
        val ready=java.util.PriorityQueue<IntArray>{
            a,b->if(a[1]!=b[1])a[1]-b[1] else a[2]-b[2]
        };
        val answer=IntArray(tasks.size);
        var next=0;
        var done=0;
        var time=0L;
        while(done<tasks.size){
            if(ready.isEmpty())time=maxOf(time,indexed[next][0].toLong());
            while(next<tasks.size&&indexed[next][0]<=time)ready.add(indexed[next++]);
            val task=ready.remove();
            answer[done++]=task[2];
            time+=task[1]
        };
        return answer
    }
}
