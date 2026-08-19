class MyCalendarTwo {
    private val bookings=mutableListOf<IntArray>();
    private val overlaps=mutableListOf<IntArray>();
    fun book(startTime:Int,endTime:Int):Boolean{
        for(overlap in overlaps)if(maxOf(startTime,overlap[0])<minOf(endTime,overlap[1]))return false;
        for(booking in bookings){
            val left=maxOf(startTime,booking[0]);
            val right=minOf(endTime,booking[1]);
            if(left<right)overlaps.add(intArrayOf(left,right))
        };
        bookings.add(intArrayOf(startTime,endTime));
        return true
    }
}
