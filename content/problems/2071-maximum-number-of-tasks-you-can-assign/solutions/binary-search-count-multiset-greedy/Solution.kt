class Solution {
    private lateinit var tasks:IntArray;
    private lateinit var workers:IntArray;
    private var pills=0;
    private var strength=0;
    private fun remove(map:java.util.TreeMap<Int,Int>,value:Int){
        if(map[value]==1)map.remove(value) else map[value]=map[value]!!-1
    };
    private fun can(count:Int):Boolean{
        val available=java.util.TreeMap<Int,Int>();
        for(i in workers.size-count until workers.size)available[workers[i]]=(available[workers[i]]?:0)+1;
        var remainingPills=pills;
        for(task in count-1 downTo 0){
            var worker=available.ceilingKey(tasks[task]);
            if(worker!=null)remove(available,worker)else{
                if(remainingPills==0)return false;
                worker=available.ceilingKey(tasks[task]-strength)?:return false;
                remainingPills--;
                remove(available,worker)
            }
        };
        return true
    };
    fun maxTaskAssign(tasks:IntArray,workers:IntArray,pills:Int,strength:Int):Int{
        tasks.sort();
        workers.sort();
        this.tasks=tasks;
        this.workers=workers;
        this.pills=pills;
        this.strength=strength;
        var left=0;
        var right=minOf(tasks.size,workers.size);
        while(left<right){
            val middle=(left+right+1)/2;
            if(can(middle))left=middle else right=middle-1
        };
        return left
    }
}
