class Solution {
    fun maxEvents(events:Array<IntArray>):Int{
        events.sortBy{
            it[0]
        };
        val ends=java.util.PriorityQueue<Int>();
        var index=0;
        var day=0;
        var answer=0;
        while(index<events.size||ends.isNotEmpty()){
            if(ends.isEmpty())day=maxOf(day,events[index][0]);
            while(index<events.size&&events[index][0]<=day)ends.add(events[index++][1]);
            while(ends.isNotEmpty()&&ends.peek()<day)ends.poll();
            if(ends.isNotEmpty()){
                ends.poll();
                answer++;
                day++
            }
        };
        return answer
    }
}
