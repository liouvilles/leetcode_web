class Solution {
    fun mostBooked(n:Int,meetings:Array<IntArray>):Int{
        meetings.sortBy{
            it[0]
        };
        val available=java.util.PriorityQueue<Int>();
        for(room in 0 until n)available.add(room);
        val busy=java.util.PriorityQueue<LongArray>(compareBy<LongArray>{
            it[0]
        }.thenBy{
            it[1]
        });
        val count=IntArray(n);
        for(meeting in meetings){
            val start=meeting[0].toLong();
            val duration=meeting[1]-meeting[0];
            while(busy.isNotEmpty()&&busy.peek()[0]<=start)available.add(busy.remove()[1].toInt());
            val room:Int;
            val end:Long;
            if(available.isNotEmpty()){
                room=available.remove();
                end=start+duration
            }else{
                val state=busy.remove();
                room=state[1].toInt();
                end=state[0]+duration
            };
            count[room]++;
            busy.add(longArrayOf(end,room.toLong()))
        };
        var answer=0;
        for(room in 1 until n)if(count[room]>count[answer])answer=room;
        return answer
    }
}
