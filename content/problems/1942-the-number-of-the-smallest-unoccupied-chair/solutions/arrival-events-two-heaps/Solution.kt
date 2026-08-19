class Solution {
    fun smallestChair(times:Array<IntArray>,targetFriend:Int):Int{
        val events=Array(times.size){
            intArrayOf(times[it][0],times[it][1],it)
        };
        events.sortBy{
            it[0]
        };
        val available=java.util.PriorityQueue<Int>();
        repeat(times.size){
            available.add(it)
        };
        val busy=java.util.PriorityQueue<IntArray>(compareBy{
            it[0]
        });
        for(event in events){
            while(busy.isNotEmpty()&&busy.peek()[0]<=event[0])available.add(busy.remove()[1]);
            val chair=available.remove();
            if(event[2]==targetFriend)return chair;
            busy.add(intArrayOf(event[1],chair))
        };
        return -1
    }
}
