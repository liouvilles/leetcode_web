class Solution {
    fun taskSchedulerII(tasks:IntArray,space:Int):Long{
        val lastDay=HashMap<Int,Long>();
        var day=0L;
        for(task in tasks){
            day++;
            lastDay[task]?.let{
                day=maxOf(day,it+space+1)
            };
            lastDay[task]=day
        };
        return day
    }
}
