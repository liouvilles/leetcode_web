class Solution {
    fun findMinimumTime(tasks:Array<IntArray>):Int{
        tasks.sortBy{
            it[1]
        };
        val maximum=tasks.maxOf{
            it[1]
        };
        val selected=BooleanArray(maximum+1);
        var answer=0;
        for(task in tasks){
            var need=task[2];
            for(time in task[0]..task[1])if(selected[time])need--;
            var time=task[1];
            while(need>0){
                if(!selected[time]){
                    selected[time]=true;
                    answer++;
                    need--
                };
                time--
            }
        };
        return answer
    }
}
