class MyCalendar {
    private val bookings=java.util.TreeMap<Int,Int>();
    fun book(startTime:Int,endTime:Int):Boolean{
        val previous=bookings.floorEntry(startTime);
        val next=bookings.ceilingEntry(startTime);
        if(previous!=null&&previous.value>startTime||next!=null&&next.key<endTime)return false;
        bookings[startTime]=endTime;
        return true
    }
}
