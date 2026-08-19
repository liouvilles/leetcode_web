class Solution {
    fun leastInterval(tasks:CharArray,n:Int):Int{
        val counts=IntArray(26);
        for(task in tasks)counts[task-'A']++;
        val maximum=counts.maxOrNull()?:0;
        val kinds=counts.count{
            it==maximum
        };
        return maxOf(tasks.size,(maximum-1)*(n+1)+kinds)
    }
}
